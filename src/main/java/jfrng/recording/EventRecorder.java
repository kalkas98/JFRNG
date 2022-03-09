package jfrng.recording;

import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordingStream;
import jdk.management.jfr.RemoteRecordingStream;
import jfrng.recording.event.ClearEvent;
import jfrng.recording.event.SynchronizationEvent;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import jdk.jfr.consumer.EventStream;
import jdk.jfr.consumer.RecordedClass;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordedFrame;

/**
 * Class for starting, stopping and handling JFR recordings
 *
 */
public class EventRecorder
{
	private RecordingStream localStream;
	private RemoteRecordingStream remoteStream;
	private List<RecordedEvent> recordedEvents;
	private Semaphore syncSemaphore;
	private boolean isRecording;
	private Recording recording;
	private RecordingConfig config;


	public EventRecorder(RecordingConfig rc)
	{
		List<RecordedEvent> tmpList = new ArrayList<RecordedEvent>();
		recordedEvents =  Collections.synchronizedList(tmpList);
		syncSemaphore = new Semaphore(0);
		config = rc;
	}
	
	public void setConfig(RecordingConfig rc)
	{
		config = rc;
	}
	
	public void startRecording()
	{
		if(config.recordToDisk())
		{
			startDiskRecording();
		}
		try
		{
			startRecordingStream();
			if(config.isRemoteRecordingEnabled())
			{
				startRemoteRecorderStream(config.getRemoteUrl());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		isRecording = true;
	}
	
	public void stopRecording()
	{
		
		synch();
		if(config.recordToDisk())
		{
			stopDiskRecording();
		}
		if(config.isRemoteRecordingEnabled())
		{
			stopRemoteRecordingStream();
		}
		
		stopRecordingStream();
		RemoveRecordingOverheadEvents();
		isRecording = false;
	}
	
	private void startDiskRecording()
	{
		if (config.getJfrConfig() != null)
		{
			recording = new Recording(config.getJfrConfig());
		}
		else
		{
			recording = new Recording();
			List<String> enabledEvents = config.getEnabledEvents();
			for (String e : enabledEvents)
			{
				recording.enable(e);
			}
		}
		recording.start();
	}
	
	private void stopDiskRecording()
	{
		try
		{
			System.out.println("Writing recording to: " + config.getPath().toString());
			recording.dump(config.getPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		recording.stop();
	}

	private void startRecordingStream() throws Exception
	{
		if (config.getJfrConfig() != null)
		{
			//Use a predifined JFR configuration if one is assigned to this recording config
			localStream = new RecordingStream(config.getJfrConfig());
		}
		else
		{
			localStream = new RecordingStream();
			List<String> enabledEvents = config.getEnabledEvents();
			for (String e : enabledEvents)
			{
				localStream.enable(e);
			}
		}
		localStream.enable(SynchronizationEvent.SYNCH_EVENT_NAME);
		localStream.setReuse(false); // Since we keep references to Events.
		localStream.onEvent(e -> {
			
			if (e.getEventType().getName().equals(SynchronizationEvent.SYNCH_EVENT_NAME))
			{
				syncSemaphore.release();
			}
			else if(e.getEventType().getName().equals(ClearEvent.CLEAR_EVENT_NAME))
			{
				recordedEvents.clear();
			}
			else
			{
				recordedEvents.add(e);
			}

		});
		
		localStream.startAsync();

		synch(); // wait for recorder stream thread to start and consume a SynchronizationEvent

	}



	private void stopRecordingStream()
	{
		localStream.close();
	}

	public Stream<RecordedEvent> getEventStream()
	{
		if (isRecording)
		{
			synch();
		}
		return recordedEvents.stream();
	}
	
	/**
	 * Commits a synchronization event to the JFR stream and tries to aquire the
	 * syncSemaphore. The JFR stream thread releases the semaphore once the event
	 *  is processed, allowing the thread calling synch to proceed.
	 *  
	 *  Call this method when you want to make sure the JFR stream thread has processed 
	 *  emitted events.
	 * 
	 * @throws InterruptedException
	 */
	private void synch()
	{
		SynchronizationEvent se = new SynchronizationEvent();
		se.begin();
		se.commit();
		try
		{
			syncSemaphore.acquire();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		} 
	}
	
	//Sends an event that clears the recorded event list
	public void clear()
	{
		ClearEvent ce = new ClearEvent();
		ce.begin();
		ce.commit();
	}
	
	/**
	 * Clears the events recorded by the stream
	 * Also restarts the JFR disk recording if there was one.
	 */
	public void reset() 
	{
		synch();
		if(config.recordToDisk())
		{
			recording.stop();
			startDiskRecording();
		}
		recordedEvents.clear();		

	}
	
	//TODO: Check that this works
	private void RemoveRecordingOverheadEvents()
	{
		synchronized(recordedEvents)
		{
			List<RecordedEvent> toBeRemoved = new ArrayList<>();
			for (RecordedEvent event : recordedEvents)
			{
				if(event.getStackTrace() != null)
				{
					List<RecordedFrame> frames = event.getStackTrace().getFrames();
					for (RecordedFrame frame : frames)
					{
						RecordedClass cls = frame.getMethod().getType();
						if(cls.getName().equals(EventRecorder.class.getName()))
						{
							toBeRemoved.add(event);
						}
					}
				}
			}
			recordedEvents.removeAll(toBeRemoved);
		}
	}
	
	public boolean isRecording()
	{
		return isRecording;
	}
	
	/**
	 * Starts recording JFR events on a remote JVM located at the given url
	 * Events are recorded via a RemoteRecordingStream.
	 * Events are added to the same list as the local JFR events.
	 * @param url - JMX service url of the host. 
	 * 		with the format: "service:jmx:rmi:///jndi/rmi://" + JMX_HOST + ":" + JMX_PORT + "/jmxrmi"
	 */
	private void startRemoteRecorderStream(String url)
	{
		remoteStream = initRemoteRecordingStream(url);
		
		if (config.getJfrConfig() != null)
		{
			Map<String,String> settings = config.getJfrConfig().getSettings();
			remoteStream.setSettings(settings);
		}
	
		List<String> enabledEvents = config.getEnabledEvents();
		for (String e : enabledEvents)
		{
			remoteStream.enable(e);
		}
		
		//TODO: Add synchronization event?
		//remoteStream.enable(SynchronizationEvent.SYNCH_EVENT_NAME);
		remoteStream.setReuse(false); // Since we keep references to Events.
		remoteStream.onEvent(e -> {
				recordedEvents.add(e);
		});
		remoteStream.startAsync();
	}
	
	private RemoteRecordingStream initRemoteRecordingStream(String url)
	{
		try
		{
			JMXServiceURL u = new JMXServiceURL(url);
			JMXConnector c = JMXConnectorFactory.connect(u);
			MBeanServerConnection conn = c.getMBeanServerConnection();
			return new RemoteRecordingStream(conn);	
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private void stopRemoteRecordingStream()
	{
		remoteStream.close();
	}

}
