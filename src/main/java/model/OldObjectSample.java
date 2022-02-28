
package model;


public class OldObjectSample {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField ALLOCATION_TIME = new JfrField("allocationTime", "long");
    public final static JfrField OBJECT_AGE = new JfrField("objectAge", "long");
    public final static JfrField LAST_KNOWN_HEAP_USAGE = new JfrField("lastKnownHeapUsage", "long");
    public final static JfrField OBJECT = new JfrField("object", "OldObject");
    public final static JfrField ARRAY_ELEMENTS = new JfrField("arrayElements", "int");
    public final static JfrField ROOT = new JfrField("root", "OldObjectGcRoot");

}
