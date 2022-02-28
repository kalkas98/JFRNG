package prototype;

import static org.testng.Assert.assertThrows;

import java.time.Duration;
import java.util.function.Predicate;
import java.util.stream.Stream;

import jdk.jfr.consumer.RecordedEvent;
import model.FileWrite;
import model.type.longJfrType;

public class MetricProvider
{
	EventRecorder recorder;

	void setRecorder(EventRecorder recorder)
	{
		this.recorder = recorder;
	}

	public Stream<RecordedEvent> getEventStream()
	{
		return recorder.getEventStream();
	}

	public void stopRecording()
	{
		recorder.stopRecording();
	}

	public boolean isRecording()
	{
		return recorder.isRecording();
	}

	/**
	 * Discard all previously recorded content.
	 */
	public void reset()
	{
		recorder.reset();
	}

	public double getDoubleAggregate(JfrEvent event, String field)
	{
		// TODO: Ensure that event has the field
		Double aggregate = getEventStream()
				.filter(e -> e.getEventType().getName().equals(event.getEventString()) && e.hasField(field))
				.map(e -> e.getDouble(field)).reduce(0.0, (res, val) -> res + val);
		return aggregate;
	}

	public double getDoubleAggregate(JfrEvent event, String field, Predicate<RecordedEvent> pred)
	{
		return getDoubleAggregate(event, field, (e) -> true);
	}

	public int getIntAggregate(JfrEvent event, String field, Predicate<RecordedEvent> pred)
	{
		// TODO: Ensure that event has the field
		int aggregate = getEventStream()
				.filter(e -> e.getEventType().getName().equals(event.getEventString()) && e.hasField(field))
				.map(e -> e.getInt(field)).reduce(0, (res, val) -> res + val);
		return aggregate;
	}

	public int getIntAggregate(JfrEvent event, String field)
	{
		return getIntAggregate(event, field, (e) -> true);
	}

	public long getLongAggregate(JfrEvent event, String field, Predicate<RecordedEvent> pred)
	{
		// TODO: Ensure that event has the field

		long aggregate = getEventStream()
				.filter(e -> e.getEventType().getName().equals(event.getEventString()) && e.hasField(field))
				.filter(pred).map(e -> e.getLong(field)).reduce(0L, (res, val) -> res + val);
		return aggregate;
	}

	public long getLongAggregate(JfrEvent event, String field)
	{
		return getLongAggregate(event, field, (e) -> true);
	}

	public Duration getDurationAggregate(JfrEvent event, String field, Predicate<RecordedEvent> pred)
	{
		// TODO: Ensure that event has the field
		Duration durationSum = getEventStream()
				.filter(e -> e.getEventType().getName().equals(event.getEventString()) && e.hasField(field))
				.map(e -> e.getDuration(field)).reduce(Duration.ZERO, (res, d) -> res.plus(d));
		return durationSum;
	}

	public Duration getDurationAggregate(JfrEvent event, String field)
	{
		return getDurationAggregate(event, field, (e) -> true);
	}

	public long getTLABAllocation()
	{
		return getLongAggregate(JfrEvent.OBJECT_ALLOCATION_OUTSIDE_TLAB, "allocationSize")
				+ getLongAggregate(JfrEvent.OBJECT_ALLOCATION_IN_NEW_TLAB, "tlabSize");
	}

	public long getTLABAllocationInThread(String threadName)
	{
		Predicate<RecordedEvent> pred = e -> e.getThread().getJavaName().equals(threadName);
		return getLongAggregate(JfrEvent.OBJECT_ALLOCATION_OUTSIDE_TLAB, "allocationSize", pred)
				+ getLongAggregate(JfrEvent.OBJECT_ALLOCATION_IN_NEW_TLAB, "tlabSize", pred);
	}

	public long getFileIORead()
	{
		return getLongAggregate(JfrEvent.FILE_READ, "bytesRead");
	}

	public long getFileIORead(String path)
	{
		Predicate<RecordedEvent> pred = (e) -> e.hasField("path") && e.getString("path").equals(path);
		return getLongAggregate(JfrEvent.FILE_READ, "bytesRead");
	}

	public long getFileIOWrite()
	{
		return getLongAggregate(JfrEvent.FILE_WRITE, "bytesWritten");
	}

	public long getFileIOWrite(String path)
	{
		Predicate<RecordedEvent> pred = (e) -> e.hasField("path") && e.getString("path") != null
				&& e.getString("path").equals(path);
		return getLongAggregate(JfrEvent.FILE_WRITE, "bytesWritten", pred);
	}

	public long getSocketIORead()
	{
		return getLongAggregate(JfrEvent.SOCKET_READ, "bytesRead");
	}

	public long getSocketIORead(int port)
	{
		Predicate<RecordedEvent> pred = (e) -> e.hasField("port") && e.getString("port") != null
				&& e.getString("port").equals(port);
		return getLongAggregate(JfrEvent.SOCKET_READ, "bytesRead");
	}

	public long getSocketIOWrite()
	{
		return getLongAggregate(JfrEvent.SOCKET_WRITE, "bytesWritten");
	}

	public long getSocketIOWrite(int port)
	{
		Predicate<RecordedEvent> pred = (e) -> e.hasField("port") && e.getString("port") != null
				&& e.getString("port").equals(port);
		return getLongAggregate(JfrEvent.SOCKET_WRITE, "bytesWritten", pred);
	}

	public long getThreadsStarted()
	{
		return getEventStream().filter(e -> e.getEventType().getName().equals(JfrEvent.THREAD_START.getEventString()))
				.count();
	}

	public long getGCPauseSum()
	{
		return getLongAggregate(JfrEvent.GARBAGE_COLLECTION, "sumOfPauses");
	}
	
	public long getAgg(longJfrType jfrField, Predicate<RecordedEvent> pred)
	{
		long aggregate = getEventStream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()))
				.filter(pred).map(e -> e.getLong(jfrField.getAttribute())).reduce(0L, (res, val) -> res + val);
		return aggregate;
	}
	
	public long getAgg(longJfrType jfrField)
	{
		return getAgg(jfrField, (e) -> true);
	}
}
