
package model;


public class ExecuteVMOperation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField OPERATION = new JfrField("operation", "String");
    public final static JfrField SAFEPOINT = new JfrField("safepoint", "boolean");
    public final static JfrField BLOCKING = new JfrField("blocking", "boolean");
    public final static JfrField CALLER = new JfrField("caller", "Thread");
    public final static JfrField SAFEPOINT_ID = new JfrField("safepointId", "long");

}
