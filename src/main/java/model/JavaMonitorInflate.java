
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class JavaMonitorInflate {

    public final static String eventName = "jdk.JavaMonitorInflate";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ClassJfrType MONITOR_CLASS = new ClassJfrType("monitorClass", eventName);
    public final static longJfrType ADDRESS = new longJfrType("address", eventName);
    public final static StringJfrType CAUSE = new StringJfrType("cause", eventName);

}
