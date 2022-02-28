
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerCPUThrottling {

    public final static String eventName = "jdk.ContainerCPUThrottling";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType CPU_ELAPSED_SLICES = new longJfrType("cpuElapsedSlices", eventName);
    public final static longJfrType CPU_THROTTLED_SLICES = new longJfrType("cpuThrottledSlices", eventName);
    public final static longJfrType CPU_THROTTLED_TIME = new longJfrType("cpuThrottledTime", eventName);

}
