
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ExecutionSample {

    public final static String eventName = "jdk.ExecutionSample";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType SAMPLED_THREAD = new ThreadJfrType("sampledThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType STATE = new StringJfrType("state", eventName);

}
