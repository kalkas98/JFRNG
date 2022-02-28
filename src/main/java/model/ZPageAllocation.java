
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ZPageAllocation {

    public final static String eventName = "jdk.ZPageAllocation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType TYPE = new StringJfrType("type", eventName);
    public final static longJfrType SIZE = new longJfrType("size", eventName);
    public final static longJfrType FLUSHED = new longJfrType("flushed", eventName);
    public final static longJfrType COMMITTED = new longJfrType("committed", eventName);
    public final static intJfrType SEGMENTS = new intJfrType("segments", eventName);
    public final static booleanJfrType NON_BLOCKING = new booleanJfrType("nonBlocking", eventName);

}
