
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ProcessStart {

    public final static String eventName = "jdk.ProcessStart";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType PID = new longJfrType("pid", eventName);
    public final static StringJfrType DIRECTORY = new StringJfrType("directory", eventName);
    public final static StringJfrType COMMAND = new StringJfrType("command", eventName);

}
