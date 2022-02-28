
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerMemoryUsage {

    public final static String eventName = "jdk.ContainerMemoryUsage";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType MEMORY_FAIL_COUNT = new longJfrType("memoryFailCount", eventName);
    public final static longJfrType MEMORY_USAGE = new longJfrType("memoryUsage", eventName);
    public final static longJfrType SWAP_MEMORY_USAGE = new longJfrType("swapMemoryUsage", eventName);

}
