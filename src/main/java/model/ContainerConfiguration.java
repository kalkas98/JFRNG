
package model;


public class ContainerConfiguration {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField CONTAINER_TYPE = new JfrField("containerType", "String");
    public final static JfrField CPU_SLICE_PERIOD = new JfrField("cpuSlicePeriod", "long");
    public final static JfrField CPU_QUOTA = new JfrField("cpuQuota", "long");
    public final static JfrField CPU_SHARES = new JfrField("cpuShares", "long");
    public final static JfrField EFFECTIVE_CPU_COUNT = new JfrField("effectiveCpuCount", "long");
    public final static JfrField MEMORY_SOFT_LIMIT = new JfrField("memorySoftLimit", "long");
    public final static JfrField MEMORY_LIMIT = new JfrField("memoryLimit", "long");
    public final static JfrField SWAP_MEMORY_LIMIT = new JfrField("swapMemoryLimit", "long");

}
