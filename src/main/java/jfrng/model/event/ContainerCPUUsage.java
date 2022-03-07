
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ContainerCPUUsage {

    public final static String EVENT = "jdk.ContainerCPUUsage";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType CPU_TIME = new longJfrType("cpuTime", EVENT);
    public final static longJfrType CPU_USER_TIME = new longJfrType("cpuUserTime", EVENT);
    public final static longJfrType CPU_SYSTEM_TIME = new longJfrType("cpuSystemTime", EVENT);

}
