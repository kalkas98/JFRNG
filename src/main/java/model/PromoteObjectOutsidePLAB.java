
package model;


public class PromoteObjectOutsidePLAB {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField OBJECT_CLASS = new JfrField("objectClass", "Class");
    public final static JfrField OBJECT_SIZE = new JfrField("objectSize", "long");
    public final static JfrField TENURING_AGE = new JfrField("tenuringAge", "int");
    public final static JfrField TENURED = new JfrField("tenured", "boolean");

}
