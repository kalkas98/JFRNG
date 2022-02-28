
package model;


public class GCLocker {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField LOCK_COUNT = new JfrField("lockCount", "int");
    public final static JfrField STALL_COUNT = new JfrField("stallCount", "int");

}
