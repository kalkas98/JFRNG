
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class JavaMonitorWait {

    public final static String eventName = "jdk.JavaMonitorWait";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ClassJfrType MONITOR_CLASS = new ClassJfrType("monitorClass", eventName);
    public final static ThreadJfrType NOTIFIER = new ThreadJfrType("notifier", eventName);
    public final static longJfrType TIMEOUT = new longJfrType("timeout", eventName);
    public final static booleanJfrType TIMED_OUT = new booleanJfrType("timedOut", eventName);
    public final static longJfrType ADDRESS = new longJfrType("address", eventName);

}
