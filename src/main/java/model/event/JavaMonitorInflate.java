
package model.event;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class JavaMonitorInflate {

    public final static String EVENT = "jdk.JavaMonitorInflate";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassJfrType MONITOR_CLASS = new ClassJfrType("monitorClass", EVENT);
    public final static longJfrType ADDRESS = new longJfrType("address", EVENT);
    public final static StringJfrType CAUSE = new StringJfrType("cause", EVENT);

}
