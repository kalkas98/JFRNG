
package model.event;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class JavaErrorThrow {

    public final static String EVENT = "jdk.JavaErrorThrow";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType MESSAGE = new StringJfrType("message", EVENT);
    public final static ClassJfrType THROWN_CLASS = new ClassJfrType("thrownClass", EVENT);

}
