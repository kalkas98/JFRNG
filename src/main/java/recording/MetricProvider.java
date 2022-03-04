package recording;


import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

import jdk.jfr.consumer.RecordedEvent;
import model.event.FileRead;
import model.event.FileWrite;
import model.event.GarbageCollection;
import model.event.ObjectAllocationInNewTLAB;
import model.event.ObjectAllocationOutsideTLAB;
import model.event.SocketRead;
import model.event.SocketWrite;
import model.event.ThreadStart;
import model.type.JfrField;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.doubleJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

/**
 * Class that exposes methods that can be used in TestNG unit tests
 * in order to access JFR metrics that were recorded during the executed unit test
 */
public class MetricProvider
{
	private EventRecorder recorder;

	public void setRecorder(EventRecorder recorder)
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

	public long getLongAggregate(longJfrType jfrField, Predicate<RecordedEvent> pred)
	{
		long aggregate = getEventStream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()))
				.filter(pred)
				.map(e -> e.getLong(jfrField.name()))
				.reduce(0L, Long::sum);
		return aggregate;
	}

	public long getLongAggregate(longJfrType jfrField)
	{
		return getLongAggregate(jfrField, (e) -> true);
	}

	public double getDoubleAggregate(doubleJfrType jfrField, Predicate<RecordedEvent> pred)
	{
		Double aggregate = getEventStream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField.name()))
				.filter(pred)
				.map(e -> e.getDouble(jfrField.name()))
				.reduce(0.0, Double::sum);
		return aggregate;
	}

	public double getDoubleAggregate(doubleJfrType jfrField)
	{
		return getDoubleAggregate(jfrField, (e) -> true);
	}

	public int getIntAggregate(intJfrType jfrField, Predicate<RecordedEvent> pred)
	{

		int aggregate = getEventStream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField.name()))
				.filter(pred).map(e -> e.getInt(jfrField.name()))
				.reduce(0, (res, val) -> res + val);
		return aggregate;
	}

	public int getIntAggregate(intJfrType field)
	{
		return getIntAggregate(field, (e) -> true);
	}

	public long getDurationAggregate(longJfrType jfrField, TimeUnit timeunit, Predicate<RecordedEvent> pred)
	{
		Duration durationSum = getEventStream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField.name()))
				.filter(pred)
				.map(e -> e.getDuration(jfrField.name()))
				.reduce(Duration.ZERO, (res, d) -> res.plus(d));
		return timeunit.convert(durationSum);
	}

	public long getDurationAggregate(longJfrType jfrField, TimeUnit timeunit)
	{
		return getDurationAggregate(jfrField, timeunit, (e) -> true);
	}

	public long getTLABAllocation()
	{
		return getLongAggregate(ObjectAllocationOutsideTLAB.ALLOCATION_SIZE)
				+ getLongAggregate(ObjectAllocationInNewTLAB.TLAB_SIZE);
	}

	public long getTLABAllocationInThread(String threadName)
	{
		Predicate<RecordedEvent> pred = e -> e.getThread().getJavaName().equals(threadName);
		return getLongAggregate(ObjectAllocationOutsideTLAB.ALLOCATION_SIZE, pred)
				+ getLongAggregate(ObjectAllocationInNewTLAB.TLAB_SIZE, pred);
	}

	public long getFileIORead()
	{
		return getLongAggregate(FileRead.BYTES_READ);
	}

	public long getFileIORead(String path)
	{
		String pathFieldName = FileRead.PATH.name();
		Predicate<RecordedEvent> pred = (e) -> e.hasField(pathFieldName) && e.getString(pathFieldName).equals(path);
		return getLongAggregate(FileRead.BYTES_READ, pred);
	}

	public long getFileIOWrite()
	{
		return getLongAggregate(FileWrite.BYTES_WRITTEN);
	}

	public long getFileIOWrite(String path)
	{
		String pathFieldName = FileWrite.PATH.name();
		Predicate<RecordedEvent> pred = (e) -> e.hasField(pathFieldName) && e.getString(pathFieldName) != null
				&& e.getString(pathFieldName).equals(path);
		return getLongAggregate(FileWrite.BYTES_WRITTEN, pred);
	}

	public long getSocketIORead()
	{
		return getLongAggregate(SocketRead.BYTES_READ);
	}

	public long getSocketIORead(int port)
	{
		String portFieldName = SocketRead.PORT.name();
		Predicate<RecordedEvent> pred = (e) -> e.hasField(portFieldName) && e.getString(portFieldName) != null
				&& e.getString(portFieldName).equals(port);
		return getLongAggregate(SocketRead.BYTES_READ, pred);
	}

	public long getSocketIOWrite()
	{
		return getLongAggregate(SocketWrite.BYTES_WRITTEN);
	}

	public long getSocketIOWrite(int port)
	{
		String portFieldName = SocketWrite.PORT.name();
		Predicate<RecordedEvent> pred = (e) -> e.hasField(portFieldName) && e.getString(portFieldName) != null
				&& e.getString(portFieldName).equals(port);
		return getLongAggregate(SocketWrite.BYTES_WRITTEN, pred);
	}

	public long getThreadsStarted()
	{
		return getEventStream()
				.filter(e -> e.getEventType().getName().equals(ThreadStart.EVENT))
				.count();
	}
	
	public long getThreadsStarted(String parent)
	{
		return getEventStream()
				.filter(e -> e.getEventType().getName().equals(ThreadStart.EVENT))
				.filter(e -> e.getThread(ThreadStart.PARENT_THREAD.name()).getJavaName().equals(parent))
				.count();
	}

	/**
	 * Returns the sum of the garbage collection pauses in the given timeunit
	 */
	public long getGCPauseSum(TimeUnit timeunit)
	{

		return getDurationAggregate(GarbageCollection.SUM_OF_PAUSES, timeunit);
	}
	
	/**
	 * Returns a stream containing events containing a value on the given field that fulfills the given predicate
	 * @param field
	 * @param pred
	 * @return
	 */
	public Stream<RecordedEvent> filterOnField(longJfrType field, Predicate<Long> pred)
	{
		return getEventStream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getLong(field.name())) );
	}
	public Stream<RecordedEvent> filterOnField(intJfrType field, Predicate<Integer> pred)
	{
		return getEventStream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getInt(field.name())) ); 
	}
	
	public Stream<RecordedEvent> filterOnField(doubleJfrType field, Predicate<Double> pred)
	{
		return getEventStream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getDouble(field.name())) );
	}

	public Stream<RecordedEvent> filterOnField(StringJfrType field, String str)
	{
		return getEventStream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						e.getString(field.name()).equals(str) );
	}

	public Stream<RecordedEvent> filterOnField(ThreadJfrType field, String threadName)
	{

		return getEventStream()
				.filter(e -> e.hasField(field.name()) && 
						e.getThread(field.name()).getJavaName().equals(threadName) &&
						e.getEventType().getName().equals(field.getEvent()));
	}

	/**
	 * Returns a stream only containing the given event
	 * @param event e.g. jdk.ThreadStart
	 * @return
	 */
	public Stream<RecordedEvent> filterOnEvent(String event)
	{

		return getEventStream()
				.filter(e -> e.getEventType().getName().equals(event));
	}

}
