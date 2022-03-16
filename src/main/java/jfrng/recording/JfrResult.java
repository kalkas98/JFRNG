package jfrng.recording;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

import jdk.jfr.consumer.RecordedClass;
import jdk.jfr.consumer.RecordedFrame;
import jdk.jfr.consumer.RecordedMethod;
import jfrng.model.event.FileRead;
import jfrng.model.event.FileWrite;
import jfrng.model.event.GarbageCollection;
import jfrng.model.event.ObjectAllocationInNewTLAB;
import jfrng.model.event.ObjectAllocationOutsideTLAB;
import jfrng.model.event.SocketRead;
import jfrng.model.event.SocketWrite;
import jfrng.model.event.ThreadStart;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.doubleJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;


/**
 * Class that exposes methods that can be used in order to access JFR metrics 
 * that were recorded during the executed unit test
 */
public class JfrResult
{
	List<RecordedJfrEvent> recordedEvents;
	public JfrResult(List<RecordedJfrEvent> recordedEvents)
	{
		
		this.recordedEvents = recordedEvents;
	}
	
	/**
	 * Get the total sum of the recorded values belonging to the given field
	 * where the recorded events also fulfill the given predicate
	 * @param jfrField - an event field with the type long
	 * @param pred - a predicate that RecordedEvents have to fullfill
	 * @return the aggregated value for the given field
	 */
	public long getLongAggregate(longJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{
		long aggregate = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()))
				.filter(pred)
				.map(e -> e.getLong(jfrField.name()))
				.reduce(0L, Long::sum);
		return aggregate;
	}

	/**
	 * Get the total sum of the recorded values for the given field
	 * @param jfrField - an event field with the type long
	 * @return the aggregated value for the given field
	 */
	public long getLongAggregate(longJfrType jfrField)
	{
		return getLongAggregate(jfrField, (e) -> true);
	}

	/**
	 * Get the total sum of the recorded values belonging to the given field
	 * where the recorded events also fulfill the given predicate
	 * @param jfrField - an event field with the type double
	 * @param pred - a predicate that RecordedEvents have to fulfill
	 * @return the aggregated value for the given field
	 */
	public double getDoubleAggregate(doubleJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{
		Double aggregate = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField.name()))
				.filter(pred)
				.map(e -> e.getDouble(jfrField.name()))
				.reduce(0.0, Double::sum);
		return aggregate;
	}

	/**
	 * Get the total sum of the recorded values for the given field
	 * @param jfrField - an event field with the type double
	 * @return the aggregated value for the given field
	 */
	public double getDoubleAggregate(doubleJfrType jfrField)
	{
		return getDoubleAggregate(jfrField, (e) -> true);
	}

	/**
	 * Get the total sum of the recorded values belonging to the given field
	 * where the recorded events also fulfill the given predicate
	 * @param jfrField - an event field with the type int
	 * @param pred - a predicate that RecordedEvents have to fulfill
	 * @return the aggregated value for the given field
	 */
	public int getIntAggregate(intJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{

		int aggregate = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField.name()))
				.filter(pred).map(e -> e.getInt(jfrField.name()))
				.reduce(0, (res, val) -> res + val);
		return aggregate;
	}
	
	/**
	 * Get the total sum of the recorded values for the given field
	 * @param jfrField - an event field with the type int
	 * @return the aggregated value for the given field
	 */
	public int getIntAggregate(intJfrType field)
	{
		return getIntAggregate(field, (e) -> true);
	}

	/**
	 * Get the total sum of the recorded values belonging to the given field
	 * where the recorded events also fulfill the given predicate
	 * @param jfrField -  an event field with the type Duration
	 * @param timeunit - The time unit for the returned value
	 * @param pred - a predicate that RecordedEvents have to fulfill
	 * @return Sum of durations in the given time unit.
	 */
	public long getDurationAggregate(longJfrType jfrField, TimeUnit timeunit, Predicate<RecordedJfrEvent> pred)
	{
		Duration durationSum = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField.name()))
				.filter(pred)
				.map(e -> e.getDuration(jfrField.name()))
				.reduce(Duration.ZERO, (res, d) -> res.plus(d));
		return timeunit.convert(durationSum);
	}

	/**
	 * Get the total sum of the recorded values belonging to the given field
	 * where the recorded events also fulfill the given predicate
	 * @param jfrField -  an event field with the type Duration
	 * @param timeunit - The time unit for the returned value
	 * @return Sum of durations in the given time unit.
	 */
	public long getDurationAggregate(longJfrType jfrField, TimeUnit timeunit)
	{
		return getDurationAggregate(jfrField, timeunit, (e) -> true);
	}

	/**
	 * Get the total number of bytes allocated
	 * 
	 * The calculation is done by adding the size of the Thread Local Allocation Buffers (TLAB) created
	 * and the allocation sizes for objects allocated outside of TLABs
	 * @return allocated memory in bytes
	 */
	public long getAllocatedMemory()
	{
		return getLongAggregate(ObjectAllocationOutsideTLAB.ALLOCATION_SIZE)
				+ getLongAggregate(ObjectAllocationInNewTLAB.TLAB_SIZE);
	}

	/**
	 * Get the total number of bytes allocated by a given thread
	 * 
	 * The calculation is done by adding the size of the Thread Local Allocation Buffers (TLAB) created
	 * and the allocation sizes for objects allocated outside of TLABs
	 * @param threadName - thread name
	 * @return allocated memory in bytes by given thread
	 */
	public long getAllocatedMemoryInThread(String threadName)
	{
		Predicate<RecordedJfrEvent> pred = e -> e.getThread().getJavaName().equals(threadName);
		return getLongAggregate(ObjectAllocationOutsideTLAB.ALLOCATION_SIZE, pred)
				+ getLongAggregate(ObjectAllocationInNewTLAB.TLAB_SIZE, pred);
	}

	/**
	 * 
	 * @return The total number of bytes read from files during the recording
	 */
	public long getFileIORead()
	{
		return getLongAggregate(FileRead.BYTES_READ);
	}

	/**
	 * 
	 * @param path - a path to a file
	 * @return The total number of bytes read from the file path during the recording
	 */
	public long getFileIORead(String path)
	{
		String pathFieldName = FileRead.PATH.name();
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(pathFieldName) && e.getString(pathFieldName).equals(path);
		return getLongAggregate(FileRead.BYTES_READ, pred);
	}

	/**
	 * 
	 * @return The total number of bytes written to files during the recording
	 */
	public long getFileIOWrite()
	{
		return getLongAggregate(FileWrite.BYTES_WRITTEN);
	}

	/**
	 * 
	 * @param path - a path to a file
	 * @return The total number of bytes written to the file path during the recording
	 */
	public long getFileIOWrite(String path)
	{
		String pathFieldName = FileWrite.PATH.name();
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(pathFieldName) && e.getString(pathFieldName) != null
				&& e.getString(pathFieldName).equals(path);
		return getLongAggregate(FileWrite.BYTES_WRITTEN, pred);
	}

	/**
	 * 
	 * @return The number of bytes read via socket IO during the recording
	 */
	public long getSocketIORead()
	{
		return getLongAggregate(SocketRead.BYTES_READ);
	}

	/**
	 * 
	 * @param port - a socket port
	 * @return The number of bytes read via socket IO from the given port during the recording
	 */
	public long getSocketIORead(int port)
	{
		String portFieldName = SocketRead.PORT.name();
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(portFieldName) && e.getString(portFieldName) != null
				&& e.getString(portFieldName).equals(port);
		return getLongAggregate(SocketRead.BYTES_READ, pred);
	}

	/**
	 * 
	 * @return The number of bytes written via socket IO during the recording
	 */
	public long getSocketIOWrite()
	{
		return getLongAggregate(SocketWrite.BYTES_WRITTEN);
	}

	/**
	 * 
	 * @param port - a socket port
	 * @return The number of bytes written via socket IO to the given port during the recording
	 */
	public long getSocketIOWrite(int port)
	{
		String portFieldName = SocketWrite.PORT.name();
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(portFieldName) && e.getString(portFieldName) != null
				&& e.getString(portFieldName).equals(port);
		return getLongAggregate(SocketWrite.BYTES_WRITTEN, pred);
	}

	/**
	 * 
	 * @return The total number of threads started during the recording
	 */
	public long getThreadsStarted()
	{
		return recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(ThreadStart.EVENT))
				.count();
	}
	
	/**
	 * 
	 * @param parent - name of a thread
	 * @return The number of threads started from the given thread
	 */
	public long getThreadsStarted(String parent)
	{
		return recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(ThreadStart.EVENT))
				.filter(e -> e.getThread(ThreadStart.PARENT_THREAD.name()).getJavaName().equals(parent))
				.count();
	}

	/**
	 * @param timeunit time unit
	 * @return the sum of the garbage collection pauses in the given timeunit
	 */
	public long getGCPauseSum(TimeUnit timeunit)
	{

		return getDurationAggregate(GarbageCollection.SUM_OF_PAUSES, timeunit);
	}
	
	/**
	 * Get a JfrResult only containing events from this result that fulfill the given predicate for the given field
	 * @param field - An jfr event field with the type long
	 * @param pred - A predicate that the value for the given field should fulfill
	 * @return A new JfrResult where the list of events only contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(longJfrType field, Predicate<Long> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getLong(field.name())) );
		return new JfrResult(filteredStream.toList());
	}
	
	/**
	 * Get a JfrResult only containing events from this result that fulfill the given predicate for the given field
	 * @param field - An jfr event field with the type int
	 * @param pred - A predicate that the value for the given field should fulfill
	 * @return A new JfrResult where the list of events only contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(intJfrType field, Predicate<Integer> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getInt(field.name())) );
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Get a JfrResult only containing events from this result that fulfill the given predicate for the given field
	 * @param field - An jfr event field with the type double
	 * @param pred - A predicate that the value for the given field should fulfill
	 * @return A new JfrResult where the list of events only contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(doubleJfrType field, Predicate<Double> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getDouble(field.name())) );
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Get a JfrResult only containing events from this result that fulfill the given predicate for the given field
	 * @param field - An jfr event field with the type String
	 * @param pred - A predicate that the value for the given field should fulfill
	 * @return A new JfrResult where the list of events only contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(StringJfrType field, String str)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						e.getString(field.name()).equals(str) );
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Get a JfrResult only containing events from this result that fulfill the given predicate for the given field
	 * @param field - An jfr event field with the type thread
	 * @param pred - A predicate that the value for the given field should fulfill
	 * @return A new JfrResult where the list of events only contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(ThreadJfrType field, String threadName)
	{

		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) && 
						e.getThread(field.name()).getJavaName().equals(threadName) &&
						e.getEventType().getName().equals(field.getEvent()));
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Returns a new JfrResult only containing the given event type
	 * @param event - name of a JFR event
	 * @return a new JfrResult only containing recorded events with the given event type
	 */
	public JfrResult filterOnEvent(String event)
	{

		Stream<RecordedJfrEvent> filteredStream = recordedEvents.stream()
																.filter(e -> e.getEventType().getName().equals(event));
		return new JfrResult(filteredStream.toList());
	}
	

	
	/**
	 * Returns a JfrResult containing only events where the given class is found in 
	 * the stacktrace of the recorded event
	 * @param cls - class to filter on
	 * @return JfrResult containing events where given class is in the stacktrace
	 */
	public JfrResult filterOnClass(Class<?>  cls)
	{

			List<RecordedJfrEvent> newList = new ArrayList<>();
			for (RecordedJfrEvent event : recordedEvents)
			{
				if(event.getStackTrace() != null)
				{
					List<RecordedFrame> frames = event.getStackTrace().getFrames();
					for (RecordedFrame frame : frames)
					{
						RecordedClass recordedClass = frame.getMethod().getType();
						if(recordedClass.getName().equals(cls.getName()))
						{
							newList.add(event);
						}
					}
				}
			}
			return new JfrResult(newList);
		
	}
	
	/**
	 * Returns a JfrResult containing only events where the given method is found in 
	 * the stacktrace
	 * @param methodName - method to filter on
	 * @return JfrResult containing events where given method is in the stacktrace
	 */
	public JfrResult filterOnMethod(String methodName)
	{

		List<RecordedJfrEvent> newList = new ArrayList<>();
		for (RecordedJfrEvent event : recordedEvents)
		{
			if(event.getStackTrace() != null)
			{
				List<RecordedFrame> frames = event.getStackTrace().getFrames();
				for (RecordedFrame frame : frames)
				{
					RecordedMethod recordedMethod = frame.getMethod();
					if(recordedMethod.getName().equals(methodName))
					{
						newList.add(event);
					}
				}
			}
		}
		return new JfrResult(newList);
		
	}
	
	public Stream<RecordedJfrEvent> stream()
	{
		return recordedEvents.stream();
	}
	
	public long count()
	{
		return recordedEvents.size();
	}
	
	/**
	 * Returns a new JfrResult with only recorded events that fulfill the
	 * given predicate
	 * @param pred predicate for RecordedJfrEvents
	 * @return a new JfrResult with only recorded events that fulfill the given predicate
	 */
	public JfrResult filter(Predicate<RecordedJfrEvent> pred)
	{
		return new JfrResult(stream().filter(pred).toList());
	}
	



}
