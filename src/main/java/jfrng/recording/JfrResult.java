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
import jfrng.model.type.JfrField;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.doubleJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;


/**
 * Class that exposes methods that can be used in order to access the JFR events
 * that were recorded during the executed test
 */
public class JfrResult
{
	List<RecordedJfrEvent> recordedEvents;
	public JfrResult(List<RecordedJfrEvent> recordedEvents)
	{
		this.recordedEvents = recordedEvents;
	}
	
	/**
	 * Get the total sum of the recorded values belonging to the given field, 
	 * where the event of the field also fulfill the given predicate.
	 * @param jfrField - an event field with the type long
	 * @param pred - a predicate that RecordedEvents have to fulfill
	 * @return the aggregated value for the given field
	 */
	public long getLongAggregate(longJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{
		long aggregate = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField))
				.filter(pred)
				.map(e -> e.getLong(jfrField))
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
	 * Get the total sum of the recorded values belonging to the given field, 
	 * where the event of the field also fulfill the given predicate.
	 * @param jfrField - an event field with the type double
	 * @param pred - a predicate that RecordedEvents have to fulfill
	 * @return the aggregated value for the given field
	 */
	public double getDoubleAggregate(doubleJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{
		Double aggregate = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField))
				.filter(pred)
				.map(e -> e.getDouble(jfrField))
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
	 * Get the total sum of the recorded values belonging to the given field, 
	 * where the event of the field also fulfill the given predicate.
	 * @param jfrField - an event field with the type int
	 * @param pred - a predicate that RecordedEvents have to fulfill
	 * @return the aggregated value for the given field
	 */
	public int getIntAggregate(intJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{

		int aggregate = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField))
				.filter(pred).map(e -> e.getInt(jfrField))
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
	 * Get the total sum of the recorded values belonging to the given field, 
	 * where the event of the field also fulfill the given predicate.
	 * @param jfrField -  an event field with the type Duration
	 * @param timeunit - The time unit for the returned value
	 * @param pred - a predicate that RecordedEvents have to fulfill
	 * @return Sum of durations in the given time unit.
	 */
	public long getDurationAggregate(longJfrType jfrField, TimeUnit timeunit, Predicate<RecordedJfrEvent> pred)
	{
		Duration durationSum = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField))
				.filter(pred)
				.map(e -> e.getDuration(jfrField))
				.reduce(Duration.ZERO, (res, d) -> res.plus(d));
		return timeunit.convert(durationSum);
	}

	/**
	 * Get the total sum of the recorded values belonging to the given field
	 * @param jfrField -  an event field with the type Duration
	 * @param timeunit - The time unit for the returned value
	 * @return Sum of durations in the given time unit.
	 */
	public long getDurationAggregate(longJfrType jfrField, TimeUnit timeunit)
	{
		return getDurationAggregate(jfrField, timeunit, (e) -> true);
	}

	/**
	 * Get the total number of bytes allocated.
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
	 * @param threadName - name of thread that allocates memory
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
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(FileRead.PATH) && 
				e.getString(FileRead.PATH) != null && e.getString(FileRead.PATH).equals(path);
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
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(FileWrite.PATH) &&  
				e.getString(FileWrite.PATH) != null && e.getString(FileWrite.PATH).equals(path);
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
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(SocketRead.PORT) && e.getInt(SocketRead.PORT) == port;
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
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(SocketWrite.PORT) && e.getInt(SocketWrite.PORT) == (port);
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
				.filter(e -> e.getThread(ThreadStart.PARENT_THREAD).getJavaName().equals(parent))
				.count();
	}

	/**
	 * @param timeunit time unit to get the duration of GC pauses in
	 * @return the sum of the garbage collection pauses in the given timeunit
	 */
	public long getGCPauseSum(TimeUnit timeunit)
	{

		return getDurationAggregate(GarbageCollection.SUM_OF_PAUSES, timeunit);
	}
	
	/**
	 * Get a JfrResult object only containing events from this result that fulfill the given predicate for the given field.
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
	 * @param field - A JFR event field with the type long
	 * @param pred - A predicate to filter values for the given field
	 * @return A new JfrResult where the list of events contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(longJfrType field, Predicate<Long> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = recordedEvents.stream()
				.filter(e -> e.hasField(field) &&
						pred.test(e.getLong(field)) );
		return new JfrResult(filteredStream.toList());
	}
	
	/**
	 * Get a JfrResult object only containing events from this result that fulfill the given predicate for the given field
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
	 * @param field - An jfr event field with the type int
	 * @param pred - A predicate that the value for the given field should fulfill
	 * @return A new JfrResult where the list of events contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(intJfrType field, Predicate<Integer> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field) &&
						pred.test(e.getInt(field)) );
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Get a JfrResult object only containing events from this result that fulfill the given predicate for the given field
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
	 * @param field - An jfr event field with the type double
	 * @param pred - A predicate that the value for the given field should fulfill
	 * @return A new JfrResult where the list of events contain events from the recording that has the given field and fulfills the predicate
	 */
	public JfrResult filterOnField(doubleJfrType field, Predicate<Double> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field) &&
						pred.test(e.getDouble(field)) );
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Get a JfrResult object only containing events from this result that fulfill the given predicate for the given field
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
	 * @param field - An jfr event field with the type String
	 * @param str - A string value that the string field should be equal to
	 * @return A new JfrResult where the list of events contain events from the recording that has the given field and the value of that field is equal to the given string value
	 */
	public JfrResult filterOnField(StringJfrType field, String str)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field) &&
						e.getString(field).equals(str) );
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Get a JfrResult object only containing events from this result that fulfill the given predicate for the given field
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.	 
	 * @param field - An jfr event field with the type thread
	 * @param threadName - A thread name that the the thread field should have
	 * @return A new JfrResult where the list of events contain events from the recording that has the given thread field and threads have the given thread name
	 */
	public JfrResult filterOnField(ThreadJfrType field, String threadName)
	{

		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field) && 
						e.getThread(field).getJavaName().equals(threadName));
		return new JfrResult(filteredStream.toList());
	}

	/**
	 * Filter a JfrResult to only contain events with the given event name
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
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
	 * Returns this JfrResult with only events where the given class is found in 
	 * the stacktrace of the recorded event
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
	 * @param cls - class to filter on
	 * @return JfrResult only containing events where given class is in the stacktrace
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
	 * Returns a copy of this JfrResult containing only events where the given method is found in 
	 * the stacktrace
	 * @param methodName - name of the method to filter on
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
	
	/**
	 * Returns a stream containing the events that were recorded.
	 * @return a Stream containing the recorded events
	 */
	public Stream<RecordedJfrEvent> stream()
	{
		return recordedEvents.stream();
	}
	
	/**
	 * Returns the number of recorded events
	 * @return number of recorded events
	 */
	public long count()
	{
		return recordedEvents.size();
	}
	
	/**
	 * Returns a JfrResult with only recorded events that fulfill the given predicate
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
	 * @param pred predicate for RecordedJfrEvents
	 * @return a new JfrResult with only recorded events that fulfill the given predicate
	 */
	public JfrResult filter(Predicate<RecordedJfrEvent> pred)
	{
		return new JfrResult(stream().filter(pred).toList());
	}
	
	/**
	 * Filter this JfrResult to only contain events with the given field
	 * Returns a new JfrResult object. Does not modify the object the method is invoked upon.
	 * @param field - JFR event field to filter on
	 * @return a new JfrResult object only containing recorded events with the given field
	 */
	public JfrResult filterOnField(JfrField field)
	{
		return new JfrResult(stream().filter(e -> e.hasField(field)).toList());
	}
	
	/**
	 * Returns true if the result contains an event with the given event name
	 * @param event
	 * @return
	 */
	public boolean hasEvent(String event)
	{
		return stream().anyMatch(e -> e.getEventType().getName().equals(event));
	}
	
	/**
	 * Returns true if the result contains an event with the given field that satisfies the given predicate for the value of the field
	 * @param field - a event field with the long type
	 * @param pred - A predicate that the value of the event field should fulfill
	 * @return
	 */
	public boolean anyMatchPredicate(longJfrType field, Predicate<Long> pred)
	{
		return this.filterOnField(field, pred).count() > 0;
	}
	
	/**
	 * Returns true if the result contains an event with the given field that satisfies the given predicate for the value of the field
	 * @param field - a event field with the int type
	 * @param pred - A predicate that the value of the event field should fulfill
	 * @return 
	 */
	public boolean anyMatchPredicate(intJfrType field, Predicate<Integer> pred)
	{
		return this.filterOnField(field, pred).count() > 0;
	}
	
	/**
	 * Returns true if the JfrResult contains an event with the given field that satisfies the given predicate for the value of the field
	 * @param field - a event field with the double type
	 * @param pred - A predicate that the value of the event field should fulfill
	 * @return
	 */
	public boolean anyMatchPredicate(doubleJfrType field, Predicate<Double> pred)
	{
		return this.filterOnField(field, pred).count() > 0;
	}
	
	/**
	 * Returns true if the given predicate is satisfies for all fields of the given field type
	 * @param field - a event field with the long type
	 * @param pred - A predicate that the value of the event field should fulfill
	 * @return
	 */
	public boolean allMatchPredicate(longJfrType field, Predicate<Long> pred)
	{
		return this.filterOnField(field).stream().allMatch(e -> pred.test(e.getLong(field)));
	}
	
	/**
	 * Returns true if the given predicate is satisfies for all fields of the given field type
	 * @param field - a event field with the int type
	 * @param pred - A predicate that the value of the event field should fulfill
	 * @return 
	 */
	public boolean allMatchPredicate(intJfrType field, Predicate<Integer> pred)
	{
		return this.filterOnField(field).stream().allMatch(e -> pred.test(e.getInt(field)));
	}
	
	/**
	 * Returns true if the given predicate is satisfies for all fields of the given field type
	 * @param field - a event field with the double type
	 * @param pred - A predicate that the value of the event field should fulfill
	 * @return
	 */
	public boolean allMatchPredicate(doubleJfrType field, Predicate<Double> pred)
	{
		return this.filterOnField(field).stream().allMatch(e -> pred.test(e.getDouble(field)));
	}
	
	public boolean containsFieldWithValue(longJfrType field, long value)
	{
		return stream().anyMatch(event -> event.getLong(field) == value);
	}

	public boolean containsFieldWithValue(intJfrType field, int value)
	{
		return stream().anyMatch(event -> event.getInt(field) == value);
	}
	
	public boolean containsFieldWithValue(doubleJfrType field, double value)
	{
		return stream().anyMatch(event -> event.getDouble(field) == value);
	}
	
	public boolean containsFieldWithValue(StringJfrType field, String value)
	{
		return filterOnField(field).stream().anyMatch(event -> event.getString(field).equals(value));
	}
	
	public JfrResult filterByThread(String threadName)
	{
		return this.filter(event -> event.getThread() != null && event.getThread().getJavaName().equals(threadName));
	}
	
	public Stream<Long> getValues(longJfrType field)
	{
		return filterOnField(field).stream().map(e -> e.getLong(field));
	}
	public Stream<String> getValues(StringJfrType field)
	{
		return filterOnField(field).stream().map(e -> e.getString(field));
	}

	public Stream<Double> getValues(doubleJfrType field)
	{
		return filterOnField(field).stream().map(e -> e.getDouble(field));
	}

	public Stream<Integer> getValues(intJfrType field)
	{
		return filterOnField(field).stream().map(e -> e.getInt(field));
	}



}
