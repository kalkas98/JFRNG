
package model;


public class ObjectAllocationInNewTLAB {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField OBJECT_CLASS = new JfrField("objectClass", "Class");
    public final static JfrField ALLOCATION_SIZE = new JfrField("allocationSize", "long");
    public final static JfrField TLAB_SIZE = new JfrField("tlabSize", "long");

}
