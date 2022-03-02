
package model.event;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

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
