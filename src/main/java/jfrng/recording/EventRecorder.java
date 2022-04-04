package jfrng.recording;

import jdk.jfr.EventSettings;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordingStream;
import jdk.management.jfr.RemoteRecordingStream;
import jfrng.recording.event.ClearEvent;
import jfrng.recording.event.SynchronizationEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import jdk.jfr.consumer.RecordedFrame;

/**
 * 
 * Class for starting, stopping and handling JFR recordings
 *
 */
public class EventRecorder
{
	protected static final String LOCAL_HOST_NAME = "local";
	
	private RecordingStream localStream;
	private List<RemoteRecordingStream> remoteStreams;
	private Deque<RecordedJfrEvent> recordedEvents;
	private Semaphore syncSemaphore;
	private boolean isRecording;
	private Recording recording;
	private RecordingConfig config;

	protected EventRecorder(RecordingConfig rc)
	{
		List<RecordedJfrEvent> tmpList = new ArrayList<RecordedJfrEvent>();
		recordedEvents =  new ConcurrentLinkedDeque();
		syncSemaphore = new Semaphore(0);
		config = rc;
		remoteStreams = new ArrayList<RemoteRecordingStream>();
	}
	
	/**
	 * Start recording via a JFR RecordingStream
	 * Depending on the configuration, other recordings might also be started
	 */
	protected void startRecording()
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
				List<String> urls = config.getRemoteUrls();
				for(String url: urls)
				{
					startRemoteRecorderStream(url);
				}
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		isRecording = true;
	}
	
	/**
	 * Stop all recordings
	 */
	protected void stopRecording()
	{
		
		synch();
		stopRecordingStream();
		if(config.recordToDisk())
		{
			stopDiskRecording();
		}
		if(config.isRemoteRecordingEnabled())
		{
			for(RemoteRecordingStream stream: remoteStreams)
			{
				stopRemoteRecordingStream(stream);
			}
		}

		removeRecordingOverheadEvents();
		isRecording = false;
	}
	
	private void startDiskRecording()
	{
		recording = new Recording();
		if (config.getJfrConfig() != null)
		{
			recording.setSettings(config.getJfrConfig().getSettings());
		}

		List<String> enabledEvents = config.getEnabledEvents();
		for (String e : enabledEvents)
		{
			EventSettings setting = recording.enable(e);
			if(config.isStacktraceDisabled())
			{
				setting.withoutStackTrace();
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
		localStream = new RecordingStream();
		if (config.getJfrConfig() != null)
		{
			//Use a predifined JFR configuration if one is assigned to this recording config
			localStream.setSettings(config.getJfrConfig().getSettings());
		}
		
		List<String> enabledEvents = config.getEnabledEvents();
		for (String e : enabledEvents)
		{
			EventSettings setting = localStream.enable(e);
			
			if(config.isStacktraceDisabled())
			{
				setting.withoutStackTrace();
			}
		}
		
		
		localStream.enable(SynchronizationEvent.SYNCH_EVENT_NAME);
		localStream.enable(ClearEvent.CLEAR_EVENT_NAME);
		localStream.setReuse(false); // Since we keep references to Events.
		localStream.setOrdered(true);
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
				RecordedJfrEvent event = new RecordedJfrEvent(e);
				event.setHost(LOCAL_HOST_NAME);
				recordedEvents.add(new RecordedJfrEvent(e));
			}

		});
		

		
		localStream.startAsync();

		synch(); // wait for recorder stream thread to start and consume a SynchronizationEvent

	}

	private void stopRecordingStream()
	{
		localStream.close();
	}
	
	protected Deque<RecordedJfrEvent> getEventList()
	{
		return recordedEvents;
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
	
	/**
	 * Sends an event that clears the recorded event list
	 */
	protected void clear()
	{
		ClearEvent ce = new ClearEvent();
		ce.begin();
		ce.commit();
	}
	
	/**
	 * Clears the events recorded by the stream
	 * Also restarts the JFR disk recording if there was one.
	 */
	protected void reset() 
	{
		synch();
		if(config.recordToDisk())
		{
			recording.stop();
			startDiskRecording();
		}
		recordedEvents.clear();		

	}
	
	/**
	 * Removes recorded events that were caused by JFR or the EventRecorder class
	 */
	private void removeRecordingOverheadEvents()
	{
		if(config.isStacktraceDisabled())
			return;
		//Remove all events where the thread name starts with JFR
		Predicate<RecordedJfrEvent> pred = event -> 
			(event.getThread() != null && event.getThread().getJavaName() != null && event.getThread().getJavaName().startsWith("JFR"));
		recordedEvents.removeIf(pred);
		//Remove all events where the EventRecorder class is found in the stack trace
		Predicate<RecordedFrame> framePred = frame -> frame.getMethod()
														   .getType()
														   .getName()
														   .equals(EventRecorder.class.getName());
		
		//Filter out null values since those seem too cause the program execution to get stuck
		Predicate<RecordedJfrEvent> frameNotNullFilter = e -> e.getStackTrace() != null && 
				e
				.getStackTrace()
				.getFrames()
				.stream()
				.allMatch(frame -> frame.getMethod() != null && frame.getMethod().getType() != null &&
						  frame.getMethod().getType().getName() != null);
		
		Predicate<RecordedJfrEvent> stackTracePred = event ->  	frameNotNullFilter.test(event) &&
																event.getStackTrace()
																     .getFrames()
																     .stream()
															    	 .anyMatch(framePred);
		recordedEvents.removeIf(stackTracePred);
	}
	
	protected boolean isRecording()
	{
		return isRecording;
	}
	
	/**
	 * Starts recording JFR events on a remote JVM.
	 * Connects to a remote MBean server by connecting a
	 * JMXConnector to a JMXConenctorServer at the given url that
	 * is attached to the MBean server
	 * Events are recorded via a RemoteRecordingStream.
	 * Events are added to the same list as the local JFR events.
	 * @param url - JMX service url of the host. 
	 * 		format of the url: "service:jmx:rmi:///jndi/rmi://" + JMX_HOST + ":" + JMX_PORT + "/jmxrmi"
	 */
	private void startRemoteRecorderStream(String url)
	{
		RemoteRecordingStream remoteStream = getRemoteRecordingStream(url);
		if (config.getJfrConfig() != null)
		{
			remoteStream.setSettings(config.getJfrConfig().getSettings());
		}
	
		List<String> enabledEvents = config.getEnabledEvents();
		for (String e : enabledEvents)
		{
			EventSettings setting = remoteStream.enable(e);
			if(config.isStacktraceDisabled())
			{
				setting.withoutStackTrace();
			}
		}
		
		remoteStream.setReuse(false); // Since we keep references to Events.
		remoteStream.onEvent(e -> {
			RecordedJfrEvent event = new RecordedJfrEvent(e);
			event.setHost(url);
			recordedEvents.add(new RecordedJfrEvent(e));
		});
		remoteStream.startAsync();
		remoteStreams.add(remoteStream);
	}
	
	/**
	 * Sets up a remote recording stream from a JMX service url
	 * @param url - A string url that can be parsed to a JMX service url
	 * @return a RemoteRecordingStream that can record JFR events on a remote host
	 */
	private RemoteRecordingStream getRemoteRecordingStream(String url)
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
	
	private void stopRemoteRecordingStream(RemoteRecordingStream rs)
	{
		rs.close();
	}
	
}
