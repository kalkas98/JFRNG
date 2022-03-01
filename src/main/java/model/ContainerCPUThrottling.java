
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerCPUThrottling {

    public final static String EVENT = "jdk.ContainerCPUThrottling";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType CPU_ELAPSED_SLICES = new longJfrType("cpuElapsedSlices", EVENT);
    public final static longJfrType CPU_THROTTLED_SLICES = new longJfrType("cpuThrottledSlices", EVENT);
    public final static longJfrType CPU_THROTTLED_TIME = new longJfrType("cpuThrottledTime", EVENT);

}
