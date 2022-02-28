
package model;


public class ContainerCPUThrottling {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField CPU_ELAPSED_SLICES = new JfrField("cpuElapsedSlices", "long");
    public final static JfrField CPU_THROTTLED_SLICES = new JfrField("cpuThrottledSlices", "long");
    public final static JfrField CPU_THROTTLED_TIME = new JfrField("cpuThrottledTime", "long");

}
