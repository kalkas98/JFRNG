
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class JavaExceptionThrow {

    public final static String eventName = "jdk.JavaExceptionThrow";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType MESSAGE = new StringJfrType("message", eventName);
    public final static ClassJfrType THROWN_CLASS = new ClassJfrType("thrownClass", eventName);

}
