
package model.event;

import model.type.OldObjectGcRootJfrType;
import model.type.OldObjectJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class OldObjectSample {

    public final static String EVENT = "jdk.OldObjectSample";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType ALLOCATION_TIME = new longJfrType("allocationTime", EVENT);
    public final static longJfrType OBJECT_AGE = new longJfrType("objectAge", EVENT);
    public final static longJfrType LAST_KNOWN_HEAP_USAGE = new longJfrType("lastKnownHeapUsage", EVENT);
    public final static OldObjectJfrType OBJECT = new OldObjectJfrType("object", EVENT);
    public final static intJfrType ARRAY_ELEMENTS = new intJfrType("arrayElements", EVENT);
    public final static OldObjectGcRootJfrType ROOT = new OldObjectGcRootJfrType("root", EVENT);

}
