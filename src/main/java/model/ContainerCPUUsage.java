
package model;


public class ContainerCPUUsage {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField CPU_TIME = new JfrField("cpuTime", "long");
    public final static JfrField CPU_USER_TIME = new JfrField("cpuUserTime", "long");
    public final static JfrField CPU_SYSTEM_TIME = new JfrField("cpuSystemTime", "long");

}
