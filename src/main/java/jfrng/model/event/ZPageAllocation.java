
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class ZPageAllocation {

    public final static String EVENT = "jdk.ZPageAllocation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType TYPE = new StringJfrType("type", EVENT);
    public final static longJfrType SIZE = new longJfrType("size", EVENT);
    public final static longJfrType FLUSHED = new longJfrType("flushed", EVENT);
    public final static longJfrType COMMITTED = new longJfrType("committed", EVENT);
    public final static intJfrType SEGMENTS = new intJfrType("segments", EVENT);
    public final static booleanJfrType NON_BLOCKING = new booleanJfrType("nonBlocking", EVENT);

}
