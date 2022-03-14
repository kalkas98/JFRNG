package jfrng.recording;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import jdk.jfr.EventType;
import jdk.jfr.ValueDescriptor;
import jdk.jfr.consumer.RecordedClass;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordedStackTrace;
import jdk.jfr.consumer.RecordedThread;

/**
 * Wrapper class for the RecordedEvent class
 *
 */
public class RecordedJfrEvent
{
	private RecordedEvent re;
	private String host;
	
	
	public RecordedJfrEvent(RecordedEvent re)
	{
		this.re = re;
	}

	public boolean getBoolean(String name)
	{
		return re.getBoolean(name);
	}

	public byte getByte(String name)
	{
		return re.getByte(name);
	}

	public char getChar(String name)
	{
		return re.getChar(name);
	}

	public RecordedClass getClass(String name)
	{
		return re.getClass(name);
	}

	public double getDouble(String name)
	{
		return re.getDouble(name);
	}

	public Duration getDuration()
	{
		return re.getDuration();
	}

	public Duration getDuration(String name)
	{
		return re.getDuration(name);
	}

	public Instant getEndTime()
	{
		return re.getEndTime();
	}

	public EventType getEventType()
	{
		return re.getEventType();
	}

	public List<ValueDescriptor> getFields()
	{
		return re.getFields();
	}

	public float getFloat(String name)
	{
		return re.getFloat(name);
	}

	public Instant getInstant(String name)
	{
		return re.getInstant(name);
	}

	public int getInt(String name)
	{
		return re.getInt(name);
	}

	public long getLong(String name)
	{
		return re.getLong(name);
	}

	public short getShort(String name)
	{
		return re.getShort(name);
	}

	public RecordedStackTrace getStackTrace()
	{
		return re.getStackTrace();
	}

	public Instant getStartTime()
	{
		return re.getStartTime();
	}

	public String getString(String name)
	{
		return re.getString(name);
	}

	public RecordedThread getThread()
	{
		return re.getThread();
	}

	public RecordedThread getThread(String name)
	{
		return re.getThread(name);
	}
	
	public boolean hasField(String name)
	{
		return re.hasField(name);
	}
	
	public boolean equals(Object obj)
	{
		return re.equals(obj);
	}
	
	public int hashCode()
	{
		return re.hashCode();
	}
	
	public String toString()
	{
		return re.toString();
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}
	
}
