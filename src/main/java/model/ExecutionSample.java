
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ExecutionSample {

    public final static String EVENT = "jdk.ExecutionSample";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType SAMPLED_THREAD = new ThreadJfrType("sampledThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType STATE = new StringJfrType("state", EVENT);

}
