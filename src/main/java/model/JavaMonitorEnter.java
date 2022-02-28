
package model;


public class JavaMonitorEnter {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField MONITOR_CLASS = new JfrField("monitorClass", "Class");
    public final static JfrField PREVIOUS_OWNER = new JfrField("previousOwner", "Thread");
    public final static JfrField ADDRESS = new JfrField("address", "long");

}
