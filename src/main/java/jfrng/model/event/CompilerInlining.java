
package jfrng.model.event;

import jfrng.model.type.CalleeMethodJfrType;
import jfrng.model.type.MethodJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

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
