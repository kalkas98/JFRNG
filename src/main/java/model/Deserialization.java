
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class Deserialization {

    public final static String eventName = "jdk.Deserialization";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static booleanJfrType FILTER_CONFIGURED = new booleanJfrType("filterConfigured", eventName);
    public final static StringJfrType FILTER_STATUS = new StringJfrType("filterStatus", eventName);
    public final static ClassJfrType TYPE = new ClassJfrType("type", eventName);
    public final static intJfrType ARRAY_LENGTH = new intJfrType("arrayLength", eventName);
    public final static longJfrType OBJECT_REFERENCES = new longJfrType("objectReferences", eventName);
    public final static longJfrType DEPTH = new longJfrType("depth", eventName);
    public final static longJfrType BYTES_READ = new longJfrType("bytesRead", eventName);
    public final static ClassJfrType EXCEPTION_TYPE = new ClassJfrType("exceptionType", eventName);
    public final static StringJfrType EXCEPTION_MESSAGE = new StringJfrType("exceptionMessage", eventName);

}
