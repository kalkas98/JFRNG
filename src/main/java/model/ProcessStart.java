
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ProcessStart {

    public final static String EVENT = "jdk.ProcessStart";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType PID = new longJfrType("pid", EVENT);
    public final static StringJfrType DIRECTORY = new StringJfrType("directory", EVENT);
    public final static StringJfrType COMMAND = new StringJfrType("command", EVENT);

}
