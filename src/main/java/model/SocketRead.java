
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class SocketRead {

    public final static String EVENT = "jdk.SocketRead";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType HOST = new StringJfrType("host", EVENT);
    public final static StringJfrType ADDRESS = new StringJfrType("address", EVENT);
    public final static intJfrType PORT = new intJfrType("port", EVENT);
    public final static longJfrType TIMEOUT = new longJfrType("timeout", EVENT);
    public final static longJfrType BYTES_READ = new longJfrType("bytesRead", EVENT);
    public final static booleanJfrType END_OF_STREAM = new booleanJfrType("endOfStream", EVENT);

}
