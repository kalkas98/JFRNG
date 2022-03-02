
package model.event;

import model.type.MethodJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class Deoptimization {

    public final static String EVENT = "jdk.Deoptimization";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", EVENT);
    public final static StringJfrType COMPILER = new StringJfrType("compiler", EVENT);
    public final static MethodJfrType METHOD = new MethodJfrType("method", EVENT);
    public final static intJfrType LINE_NUMBER = new intJfrType("lineNumber", EVENT);
    public final static intJfrType BCI = new intJfrType("bci", EVENT);
    public final static StringJfrType INSTRUCTION = new StringJfrType("instruction", EVENT);
    public final static StringJfrType REASON = new StringJfrType("reason", EVENT);
    public final static StringJfrType ACTION = new StringJfrType("action", EVENT);

}
