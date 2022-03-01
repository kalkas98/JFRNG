
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ThreadPark {

    public final static String EVENT = "jdk.ThreadPark";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassJfrType PARKED_CLASS = new ClassJfrType("parkedClass", EVENT);
    public final static longJfrType TIMEOUT = new longJfrType("timeout", EVENT);
    public final static longJfrType UNTIL = new longJfrType("until", EVENT);
    public final static longJfrType ADDRESS = new longJfrType("address", EVENT);

}
