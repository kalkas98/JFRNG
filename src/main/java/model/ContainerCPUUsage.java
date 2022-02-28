
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerCPUUsage {

    public final static String eventName = "jdk.ContainerCPUUsage";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType CPU_TIME = new longJfrType("cpuTime", eventName);
    public final static longJfrType CPU_USER_TIME = new longJfrType("cpuUserTime", eventName);
    public final static longJfrType CPU_SYSTEM_TIME = new longJfrType("cpuSystemTime", eventName);

}
