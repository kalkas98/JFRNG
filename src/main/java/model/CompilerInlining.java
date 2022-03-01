
package model;

import model.type.CalleeMethodJfrType;
import model.type.MethodJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CompilerInlining {

    public final static String EVENT = "jdk.CompilerInlining";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", EVENT);
    public final static MethodJfrType CALLER = new MethodJfrType("caller", EVENT);
    public final static CalleeMethodJfrType CALLEE = new CalleeMethodJfrType("callee", EVENT);
    public final static booleanJfrType SUCCEEDED = new booleanJfrType("succeeded", EVENT);
    public final static StringJfrType MESSAGE = new StringJfrType("message", EVENT);
    public final static intJfrType BCI = new intJfrType("bci", EVENT);

}
