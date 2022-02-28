
package model;

import model.type.CalleeMethodJfrType;
import model.type.MethodJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CompilerInlining {

    public final static String eventName = "jdk.CompilerInlining";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", eventName);
    public final static MethodJfrType CALLER = new MethodJfrType("caller", eventName);
    public final static CalleeMethodJfrType CALLEE = new CalleeMethodJfrType("callee", eventName);
    public final static booleanJfrType SUCCEEDED = new booleanJfrType("succeeded", eventName);
    public final static StringJfrType MESSAGE = new StringJfrType("message", eventName);
    public final static intJfrType BCI = new intJfrType("bci", eventName);

}
