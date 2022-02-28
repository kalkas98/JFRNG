
package model;


public class JavaMonitorInflate {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField MONITOR_CLASS = new JfrField("monitorClass", "Class");
    public final static JfrField ADDRESS = new JfrField("address", "long");
    public final static JfrField CAUSE = new JfrField("cause", "String");

}
