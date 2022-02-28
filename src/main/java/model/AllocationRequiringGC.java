
package model;


public class AllocationRequiringGC {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField SIZE = new JfrField("size", "long");

}
