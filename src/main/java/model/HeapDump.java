
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class HeapDump {

    public final static String eventName = "jdk.HeapDump";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType DESTINATION = new StringJfrType("destination", eventName);
    public final static longJfrType SIZE = new longJfrType("size", eventName);
    public final static booleanJfrType GC_BEFORE_DUMP = new booleanJfrType("gcBeforeDump", eventName);
    public final static booleanJfrType ON_OUT_OF_MEMORY_ERROR = new booleanJfrType("onOutOfMemoryError", eventName);

}
