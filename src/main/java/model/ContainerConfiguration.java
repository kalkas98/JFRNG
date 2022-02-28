
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerConfiguration {

    public final static String eventName = "jdk.ContainerConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType CONTAINER_TYPE = new StringJfrType("containerType", eventName);
    public final static longJfrType CPU_SLICE_PERIOD = new longJfrType("cpuSlicePeriod", eventName);
    public final static longJfrType CPU_QUOTA = new longJfrType("cpuQuota", eventName);
    public final static longJfrType CPU_SHARES = new longJfrType("cpuShares", eventName);
    public final static longJfrType EFFECTIVE_CPU_COUNT = new longJfrType("effectiveCpuCount", eventName);
    public final static longJfrType MEMORY_SOFT_LIMIT = new longJfrType("memorySoftLimit", eventName);
    public final static longJfrType MEMORY_LIMIT = new longJfrType("memoryLimit", eventName);
    public final static longJfrType SWAP_MEMORY_LIMIT = new longJfrType("swapMemoryLimit", eventName);

}
