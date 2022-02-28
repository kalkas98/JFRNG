
package model;

import model.type.OldObjectGcRootJfrType;
import model.type.OldObjectJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class OldObjectSample {

    public final static String eventName = "jdk.OldObjectSample";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType ALLOCATION_TIME = new longJfrType("allocationTime", eventName);
    public final static longJfrType OBJECT_AGE = new longJfrType("objectAge", eventName);
    public final static longJfrType LAST_KNOWN_HEAP_USAGE = new longJfrType("lastKnownHeapUsage", eventName);
    public final static OldObjectJfrType OBJECT = new OldObjectJfrType("object", eventName);
    public final static intJfrType ARRAY_ELEMENTS = new intJfrType("arrayElements", eventName);
    public final static OldObjectGcRootJfrType ROOT = new OldObjectGcRootJfrType("root", eventName);

}
