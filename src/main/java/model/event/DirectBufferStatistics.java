
package model.event;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class DirectBufferStatistics {

    public final static String EVENT = "jdk.DirectBufferStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType MAX_CAPACITY = new longJfrType("maxCapacity", EVENT);
    public final static longJfrType COUNT = new longJfrType("count", EVENT);
    public final static longJfrType TOTAL_CAPACITY = new longJfrType("totalCapacity", EVENT);
    public final static longJfrType MEMORY_USED = new longJfrType("memoryUsed", EVENT);

}
