
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.longJfrType;

public class HeapDump {

    public final static String EVENT = "jdk.HeapDump";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType DESTINATION = new StringJfrType("destination", EVENT);
    public final static longJfrType SIZE = new longJfrType("size", EVENT);
    public final static booleanJfrType GC_BEFORE_DUMP = new booleanJfrType("gcBeforeDump", EVENT);
    public final static booleanJfrType ON_OUT_OF_MEMORY_ERROR = new booleanJfrType("onOutOfMemoryError", EVENT);

}
