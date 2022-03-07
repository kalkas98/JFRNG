
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.longJfrType;

public class FileRead {

    public final static String EVENT = "jdk.FileRead";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType PATH = new StringJfrType("path", EVENT);
    public final static longJfrType BYTES_READ = new longJfrType("bytesRead", EVENT);
    public final static booleanJfrType END_OF_FILE = new booleanJfrType("endOfFile", EVENT);

}
