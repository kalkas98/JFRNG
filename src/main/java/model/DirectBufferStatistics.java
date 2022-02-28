
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class DirectBufferStatistics {

    public final static String eventName = "jdk.DirectBufferStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType MAX_CAPACITY = new longJfrType("maxCapacity", eventName);
    public final static longJfrType COUNT = new longJfrType("count", eventName);
    public final static longJfrType TOTAL_CAPACITY = new longJfrType("totalCapacity", eventName);
    public final static longJfrType MEMORY_USED = new longJfrType("memoryUsed", eventName);

}
