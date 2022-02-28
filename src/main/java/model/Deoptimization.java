
package model;

import model.type.MethodJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class Deoptimization {

    public final static String eventName = "jdk.Deoptimization";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", eventName);
    public final static StringJfrType COMPILER = new StringJfrType("compiler", eventName);
    public final static MethodJfrType METHOD = new MethodJfrType("method", eventName);
    public final static intJfrType LINE_NUMBER = new intJfrType("lineNumber", eventName);
    public final static intJfrType BCI = new intJfrType("bci", eventName);
    public final static StringJfrType INSTRUCTION = new StringJfrType("instruction", eventName);
    public final static StringJfrType REASON = new StringJfrType("reason", eventName);
    public final static StringJfrType ACTION = new StringJfrType("action", eventName);

}
