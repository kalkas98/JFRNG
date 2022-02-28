
package model;


public class ZPageAllocation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField TYPE = new JfrField("type", "String");
    public final static JfrField SIZE = new JfrField("size", "long");
    public final static JfrField FLUSHED = new JfrField("flushed", "long");
    public final static JfrField COMMITTED = new JfrField("committed", "long");
    public final static JfrField SEGMENTS = new JfrField("segments", "int");
    public final static JfrField NON_BLOCKING = new JfrField("nonBlocking", "boolean");

}
