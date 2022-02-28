
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class SocketRead {

    public final static String eventName = "jdk.SocketRead";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType HOST = new StringJfrType("host", eventName);
    public final static StringJfrType ADDRESS = new StringJfrType("address", eventName);
    public final static intJfrType PORT = new intJfrType("port", eventName);
    public final static longJfrType TIMEOUT = new longJfrType("timeout", eventName);
    public final static longJfrType BYTES_READ = new longJfrType("bytesRead", eventName);
    public final static booleanJfrType END_OF_STREAM = new booleanJfrType("endOfStream", eventName);

}
