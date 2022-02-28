
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ThreadPark {

    public final static String eventName = "jdk.ThreadPark";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ClassJfrType PARKED_CLASS = new ClassJfrType("parkedClass", eventName);
    public final static longJfrType TIMEOUT = new longJfrType("timeout", eventName);
    public final static longJfrType UNTIL = new longJfrType("until", eventName);
    public final static longJfrType ADDRESS = new longJfrType("address", eventName);

}
