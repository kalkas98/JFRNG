
package model.event;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCLocker {

    public final static String EVENT = "jdk.GCLocker";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static intJfrType LOCK_COUNT = new intJfrType("lockCount", EVENT);
    public final static intJfrType STALL_COUNT = new intJfrType("stallCount", EVENT);

}
