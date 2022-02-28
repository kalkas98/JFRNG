
package model;

import model.type.MethodJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ReservedStackActivation {

    public final static String eventName = "jdk.ReservedStackActivation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static MethodJfrType METHOD = new MethodJfrType("method", eventName);

}
