
package model.event;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerMemoryUsage {

    public final static String EVENT = "jdk.ContainerMemoryUsage";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType MEMORY_FAIL_COUNT = new longJfrType("memoryFailCount", EVENT);
    public final static longJfrType MEMORY_USAGE = new longJfrType("memoryUsage", EVENT);
    public final static longJfrType SWAP_MEMORY_USAGE = new longJfrType("swapMemoryUsage", EVENT);

}
