
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerConfiguration {

    public final static String EVENT = "jdk.ContainerConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType CONTAINER_TYPE = new StringJfrType("containerType", EVENT);
    public final static longJfrType CPU_SLICE_PERIOD = new longJfrType("cpuSlicePeriod", EVENT);
    public final static longJfrType CPU_QUOTA = new longJfrType("cpuQuota", EVENT);
    public final static longJfrType CPU_SHARES = new longJfrType("cpuShares", EVENT);
    public final static longJfrType EFFECTIVE_CPU_COUNT = new longJfrType("effectiveCpuCount", EVENT);
    public final static longJfrType MEMORY_SOFT_LIMIT = new longJfrType("memorySoftLimit", EVENT);
    public final static longJfrType MEMORY_LIMIT = new longJfrType("memoryLimit", EVENT);
    public final static longJfrType SWAP_MEMORY_LIMIT = new longJfrType("swapMemoryLimit", EVENT);

}
