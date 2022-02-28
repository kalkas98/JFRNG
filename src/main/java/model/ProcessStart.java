
package model;


public class ProcessStart {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField PID = new JfrField("pid", "long");
    public final static JfrField DIRECTORY = new JfrField("directory", "String");
    public final static JfrField COMMAND = new JfrField("command", "String");

}
