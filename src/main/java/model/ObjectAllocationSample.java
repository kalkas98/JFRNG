
package model;


public class ObjectAllocationSample {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField OBJECT_CLASS = new JfrField("objectClass", "Class");
    public final static JfrField WEIGHT = new JfrField("weight", "long");

}
