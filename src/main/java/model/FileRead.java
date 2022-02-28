
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class FileRead {

    public final static String eventName = "jdk.FileRead";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType PATH = new StringJfrType("path", eventName);
    public final static longJfrType BYTES_READ = new longJfrType("bytesRead", eventName);
    public final static booleanJfrType END_OF_FILE = new booleanJfrType("endOfFile", eventName);

}
