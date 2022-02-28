
package model;


public class JavaMonitorWait {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField MONITOR_CLASS = new JfrField("monitorClass", "Class");
    public final static JfrField NOTIFIER = new JfrField("notifier", "Thread");
    public final static JfrField TIMEOUT = new JfrField("timeout", "long");
    public final static JfrField TIMED_OUT = new JfrField("timedOut", "boolean");
    public final static JfrField ADDRESS = new JfrField("address", "long");

}
