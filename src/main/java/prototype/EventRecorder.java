package prototype;

import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordingStream;
import jdk.jfr.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import jdk.jfr.consumer.RecordedEvent;

public class EventRecorder
{
	private RecordingStream rs;
	private List<RecordedEvent> recordedEvents;
	private Semaphore syncSemaphore;
	private boolean hasSynced = false;
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
	}
	
	public void stopRecording()
	{
		if(config.recordToDisk())
		{
			stopDiskRecording();
		}
		stopRecordingStream();
	}
	
	public void startDiskRecording()
	{
		if (config.getJfrConfig() != null)
		{
			recording = new Recording(config.getJfrConfig());
		}
		else
		{
			recording = new Recording();
			List<JfrEvent> enabledEvents = config.getEnabledEvents();
			for (JfrEvent e : enabledEvents)
			{
				recording.enable(e.getEventString());
			}
		}
		recording.start();
	}
	
	public void stopDiskRecording()
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

	public void startRecordingStream() throws Exception
	{
		recordedEvents.clear();
		if (config.getJfrConfig() != null)
		{
			rs = new RecordingStream(config.getJfrConfig());
		}
		else
		{
			rs = new RecordingStream();
			List<JfrEvent> enabledEvents = config.getEnabledEvents();
			for (JfrEvent e : enabledEvents)
			{
				rs.enable(e.getEventString());
			}
		}
		rs.enable(SynchronizationEvent.SYNCH_EVENT_NAME);
		rs.setReuse(false); // Since we keep references to Events.
		rs.onEvent(e -> {
			if (e.getEventType().getName().equals(SynchronizationEvent.SYNCH_EVENT_NAME))
			{
				syncSemaphore.release();
			}
			else
			{
				recordedEvents.add(e);
			}

		});
		rs.startAsync();

		synch(); // wait for recorder stream thread to start and consume a SynchronizationEvent

	}

	public void stopRecordingStream()
	{
		rs.close();
	}

	public Stream<RecordedEvent> getEventStream()
	{
		if (!hasSynced)
		{
			try
			{
				synch();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		return recordedEvents.stream();
	}
	
	/**
	 * Commits a synchronization event to the JFR stream and tries to aquire the
	 * syncSemaphore The JFR stream thread releases the semaphore once the event
	 * processed is , allowing the syncing thread to proceed
	 * 
	 * @throws InterruptedException
	 */
	private void synch() throws InterruptedException
	{
		SynchronizationEvent se = new SynchronizationEvent();
		se.begin();
		se.commit();
		syncSemaphore.acquire(); // Wait until stream thread processes synch event
	}

}
