
package model;


public class HeapDump {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField DESTINATION = new JfrField("destination", "String");
    public final static JfrField SIZE = new JfrField("size", "long");
    public final static JfrField GC_BEFORE_DUMP = new JfrField("gcBeforeDump", "boolean");
    public final static JfrField ON_OUT_OF_MEMORY_ERROR = new JfrField("onOutOfMemoryError", "boolean");

}
