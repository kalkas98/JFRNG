
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class JavaMonitorWait {

    public final static String EVENT = "jdk.JavaMonitorWait";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassJfrType MONITOR_CLASS = new ClassJfrType("monitorClass", EVENT);
    public final static ThreadJfrType NOTIFIER = new ThreadJfrType("notifier", EVENT);
    public final static longJfrType TIMEOUT = new longJfrType("timeout", EVENT);
    public final static booleanJfrType TIMED_OUT = new booleanJfrType("timedOut", EVENT);
    public final static longJfrType ADDRESS = new longJfrType("address", EVENT);

}
