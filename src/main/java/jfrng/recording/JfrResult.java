package jfrng.recording;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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
 * Class that exposes methods that can be used in TestNG unit tests
 * in order to access JFR metrics that were recorded during the executed unit test
 */
public class JfrResult
{
	List<RecordedJfrEvent> recordedEvents;
	public JfrResult(List<RecordedJfrEvent> recordedEvents)
	{
		
		this.recordedEvents = recordedEvents;
	}
	
	
	public long getLongAggregate(longJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{
		long aggregate = recordedEvents.stream()
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

	public double getDoubleAggregate(doubleJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{
		Double aggregate = recordedEvents.stream()
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

	public int getIntAggregate(intJfrType jfrField, Predicate<RecordedJfrEvent> pred)
	{

		int aggregate = recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(jfrField.getEvent()) && e.hasField(jfrField.name()))
				.filter(pred).map(e -> e.getInt(jfrField.name()))
				.reduce(0, (res, val) -> res + val);
		return aggregate;
	}

	public int getIntAggregate(intJfrType field)
	{
		return getIntAggregate(field, (e) -> true);
	}

	public long getDurationAggregate(longJfrType jfrField, TimeUnit timeunit, Predicate<RecordedJfrEvent> pred)
	{
		Duration durationSum = recordedEvents.stream()
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
		Predicate<RecordedJfrEvent> pred = e -> e.getThread().getJavaName().equals(threadName);
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
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(pathFieldName) && e.getString(pathFieldName).equals(path);
		return getLongAggregate(FileRead.BYTES_READ, pred);
	}

	public long getFileIOWrite()
	{
		return getLongAggregate(FileWrite.BYTES_WRITTEN);
	}

	public long getFileIOWrite(String path)
	{
		String pathFieldName = FileWrite.PATH.name();
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(pathFieldName) && e.getString(pathFieldName) != null
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
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(portFieldName) && e.getString(portFieldName) != null
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
		Predicate<RecordedJfrEvent> pred = (e) -> e.hasField(portFieldName) && e.getString(portFieldName) != null
				&& e.getString(portFieldName).equals(port);
		return getLongAggregate(SocketWrite.BYTES_WRITTEN, pred);
	}

	public long getThreadsStarted()
	{
		return recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(ThreadStart.EVENT))
				.count();
	}
	
	public long getThreadsStarted(String parent)
	{
		return recordedEvents.stream()
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
	 * Returns a JfrResult containing events containing a value on the given field that fulfills the given predicate
	 * @param field
	 * @param pred
	 * @return
	 */
	public JfrResult filterOnField(longJfrType field, Predicate<Long> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getLong(field.name())) );
		return new JfrResult(filteredStream.toList());
	}
	public JfrResult filterOnField(intJfrType field, Predicate<Integer> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getInt(field.name())) );
		return new JfrResult(filteredStream.toList());
	}
	
	public JfrResult filterOnField(doubleJfrType field, Predicate<Double> pred)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						pred.test(e.getDouble(field.name())) );
		return new JfrResult(filteredStream.toList());
	}

	public JfrResult filterOnField(StringJfrType field, String str)
	{
		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) &&
						e.getEventType().getName().equals(field.getEvent()) &&
						e.getString(field.name()).equals(str) );
		return new JfrResult(filteredStream.toList());
	}

	public JfrResult filterOnField(ThreadJfrType field, String threadName)
	{

		Stream<RecordedJfrEvent> filteredStream = 
				recordedEvents.stream()
				.filter(e -> e.hasField(field.name()) && 
						e.getThread(field.name()).getJavaName().equals(threadName) &&
						e.getEventType().getName().equals(field.getEvent()));
		return new JfrResult(filteredStream.toList());
	}

	public JfrResult filterOnEvent(String event)
	{

		Stream<RecordedJfrEvent> filteredStream =  
				recordedEvents.stream()
				.filter(e -> e.getEventType().getName().equals(event));
		return new JfrResult(filteredStream.toList());
	}
	

	
	/***
	 * Returns a JfrResult containing only events where the given class is found in 
	 * the stacktrace of the event
	 * @param cls - class to filter on
	 * @return stream containing events where given class is in the stacktrace
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
	
	/***
	 * Returns a JfrResult containing only events where the given method is found in 
	 * the stacktrace of the event
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
	
	public JfrResult filter(Predicate<RecordedJfrEvent> pred)
	{
		return new JfrResult(stream().filter(pred).toList());
	}
	



}
