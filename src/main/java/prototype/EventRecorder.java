package prototype;

import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordingStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

import jdk.jfr.consumer.RecordedEvent;

/**
 * Class for starting, stopping and handling JFR recordings
 *
 */
public class EventRecorder
{
	private RecordingStream rs;
	private List<RecordedEvent> recordedEvents;
	private Semaphore syncSemaphore;
	private boolean isRecording;
	private Recording recording;
	private RecordingConfig config;


	public EventRecorder(RecordingConfig rc)
	{
		recordedEvents = new ArrayList<RecordedEvent>();
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
		stopRecordingStream();
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
		recordedEvents.clear();
		if (config.getJfrConfig() != null)
		{
			rs = new RecordingStream(config.getJfrConfig());
		}
		else
		{
			rs = new RecordingStream();
			List<String> enabledEvents = config.getEnabledEvents();
			for (String e : enabledEvents)
			{
				rs.enable(e);
			}
		}
		rs.enable(SynchronizationEvent.SYNCH_EVENT_NAME);
		rs.setReuse(false); // Since we keep references to Events.
		rs.onEvent(e -> {
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
		rs.startAsync();

		synch(); // wait for recorder stream thread to start and consume a SynchronizationEvent

	}

	private void stopRecordingStream()
	{
		rs.close();
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
	 * processed is , allowing the thread calling synch to proceed
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
	
	public boolean isRecording()
	{
		return isRecording;
	}

}
