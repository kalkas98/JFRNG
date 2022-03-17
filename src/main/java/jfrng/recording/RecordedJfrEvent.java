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
import jfrng.model.type.ClassJfrType;
import jfrng.model.type.JfrField;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.byteJfrType;
import jfrng.model.type.charJfrType;
import jfrng.model.type.doubleJfrType;
import jfrng.model.type.floatJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;
import jfrng.model.type.shortJfrType;

/**
 * Wrapper class for the RecordedEvent class
 * Can't inherit from RecordedEvent since it is final so we do this instead
 */
public class RecordedJfrEvent
{
	private RecordedEvent re;
	private String host;
	
	
	public RecordedJfrEvent(RecordedEvent re)
	{
		this.re = re;
	}


	/**
	 * Returns the boolean value for a given field of the event
	 * @param field - field with the type boolean
	 * @return the value of the field, true or false
	 */
	public boolean getBoolean(booleanJfrType field)
	{
		return re.getBoolean(field.name());
	}

	/**
	 * Returns the byte value for a given field of the event
	 * @param field - field with the type byte
	 * @return the value of the given field for the event
	 */
	public byte getByte(byteJfrType field)
	{
		return re.getByte(field.name());
	}

	/**
	 * Returns the char value for a given field of the event
	 * @param field - field with the char type
	 * @return the char value of the given field for the event
	 */
	public char getChar(charJfrType field)
	{
		return re.getChar(field.name());
	}

	/**
	 * Returns the RecordedClass value for a given field of a event
	 * @param field - field with the class type
	 * @return the class value of the given field for the event, returned as a RecordedClass object
	 */
	public RecordedClass getClass(ClassJfrType field)
	{
		return re.getClass(field.name());
	}

	/**
	 * Returns the char value for a given field of the event
	 * @param field - field with the char type
	 * @return the char value of the given field for the event
	 */
	public double getDouble(doubleJfrType field)
	{
		return re.getDouble(field.name());
	}

	/**
	 * Returns the duration of the event, measured in nanoseconds.
	 * @return the duration of the event, measured in nanoseconds.
	 */
	public Duration getDuration()
	{
		return re.getDuration();
	}

	/**
	 * Returns the value for a duration-field of an event
	 * @param field - A long-type field that has a Timespan, See here if a field has a Timespan:  https://bestsolution-at.github.io/jfr-doc/openjdk-17.html
	 * @return The duration value
	 */
	public Duration getDuration(longJfrType field)
	{
		return re.getDuration(field.name());
	}

	/**
	 * Returns the end time of the event
	 * @return end time of the event as a Instant object
	 */
	public Instant getEndTime()
	{
		return re.getEndTime();
	}

	/**
	 * Get the event type
	 * @return the EventType object representing the event
	 */
	public EventType getEventType()
	{
		return re.getEventType();
	}

	/**
	 * Get the fields that the recorded has
	 * @return A list containing ValueDescriptors that describe the fields of this event
	 */
	public List<ValueDescriptor> getFields()
	{
		return re.getFields();
	}

	/**
	 * Returns the value for a float-field
	 * @param field - an event field with the type float
	 * @return The value of the field
	 */
	public float getFloat(floatJfrType field)
	{
		return re.getFloat(field.name());
	}

	/**
	 * Returns a timestamp in the form of an Instant object for a long type field with the content type "Timestamp".
	 * Look here to see if a field has a Timestamp: https://bestsolution-at.github.io/jfr-doc/openjdk-17.html
	 * @param field - long type event field with a timestamp
	 * @return An Instant object representing a timestamp for a point in time
	 */
	public Instant getInstant(longJfrType field)
	{
		return re.getInstant(field.name());
	}

	/**
	 * Get the value for a int field
	 * @param field - field with an int type
	 * @return The value of the int field
	 */
	public int getInt(intJfrType field)
	{
		return re.getInt(field.name());
	}

	/**
	 * Get the value for a long field
	 * @param field - field with an long type
	 * @return The value of the long field
	 */
	public long getLong(longJfrType field)
	{
		return re.getLong(field.name());
	}

	/**
	 * Get the value for a short field
	 * @param field - field with an short type
	 * @return The value of the short field
	 */
	public short getShort(shortJfrType field)
	{
		return re.getShort(field.name());
	}

	/**
	 * Get the stack trace of the event
	 * @return the stack trace that was recorded by JFR
	 */
	public RecordedStackTrace getStackTrace()
	{
		return re.getStackTrace();
	}

	/**
	 * Get the start time of the event
	 * @return start time of the event as an Instant object
	 */
	public Instant getStartTime()
	{
		return re.getStartTime();
	}

	/**
	 * Get the value for a string field
	 * @param field - field with an String type
	 * @return The value of the String field
	 */
	public String getString(StringJfrType field)
	{
		return re.getString(field.name());
	}

	/**
	 * Returns the thread that commited this event
	 * @return the thread that commited this event
	 */
	public RecordedThread getThread()
	{
		return re.getThread();
	}

	/**
	 * Get the value for a thread field
	 * @param field - field with an thread type
	 * @return The value of the thread field
	 */
	public RecordedThread getThread(ThreadJfrType field)
	{
		return re.getThread(field.name());
	}
	
	/**
	 * Returns true if the event has the given field
	 * @param field - A JFR event field object
	 * @return true if the event has the field, false otherwise
	 */
	public boolean hasField(JfrField field)
	{
		return re.hasField(field.name());
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

	/**
	 * Get the JMX service URL the event was recorded on
	 * If the event was recorded on the JVM the test run in
	 * "local" is returned
	 * @return
	 */
	public String getHost()
	{
		return host;
	}

	/**
	 * Specify what host recorded this event
	 * @param host JMX service url of the host that this event was recorded on
	 */
	public void setHost(String host)
	{
		this.host = host;
	}
	
}
