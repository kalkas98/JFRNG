
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCLocker {

    public final static String eventName = "jdk.GCLocker";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static intJfrType LOCK_COUNT = new intJfrType("lockCount", eventName);
    public final static intJfrType STALL_COUNT = new intJfrType("stallCount", eventName);

}
