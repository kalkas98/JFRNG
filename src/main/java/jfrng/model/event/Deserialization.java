
package jfrng.model.event;

import jfrng.model.type.ClassJfrType;
import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class Deserialization {

    public final static String EVENT = "jdk.Deserialization";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static booleanJfrType FILTER_CONFIGURED = new booleanJfrType("filterConfigured", EVENT);
    public final static StringJfrType FILTER_STATUS = new StringJfrType("filterStatus", EVENT);
    public final static ClassJfrType TYPE = new ClassJfrType("type", EVENT);
    public final static intJfrType ARRAY_LENGTH = new intJfrType("arrayLength", EVENT);
    public final static longJfrType OBJECT_REFERENCES = new longJfrType("objectReferences", EVENT);
    public final static longJfrType DEPTH = new longJfrType("depth", EVENT);
    public final static longJfrType BYTES_READ = new longJfrType("bytesRead", EVENT);
    public final static ClassJfrType EXCEPTION_TYPE = new ClassJfrType("exceptionType", EVENT);
    public final static StringJfrType EXCEPTION_MESSAGE = new StringJfrType("exceptionMessage", EVENT);

}
