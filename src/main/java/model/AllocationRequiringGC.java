
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class AllocationRequiringGC {

    public final static String eventName = "jdk.AllocationRequiringGC";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static longJfrType SIZE = new longJfrType("size", eventName);

}
