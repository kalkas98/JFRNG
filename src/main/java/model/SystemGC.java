
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class SystemGC {

    public final static String eventName = "jdk.SystemGC";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static booleanJfrType INVOKED_CONCURRENT = new booleanJfrType("invokedConcurrent", eventName);

}
