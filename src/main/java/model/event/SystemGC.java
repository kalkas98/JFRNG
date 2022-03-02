
package model.event;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class SystemGC {

    public final static String EVENT = "jdk.SystemGC";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static booleanJfrType INVOKED_CONCURRENT = new booleanJfrType("invokedConcurrent", EVENT);

}
