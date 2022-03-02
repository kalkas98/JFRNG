
package model.event;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class AllocationRequiringGC {

    public final static String EVENT = "jdk.AllocationRequiringGC";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static longJfrType SIZE = new longJfrType("size", EVENT);

}
