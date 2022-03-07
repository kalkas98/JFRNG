
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class CompilationFailure {

    public final static String EVENT = "jdk.CompilationFailure";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType FAILURE_MESSAGE = new StringJfrType("failureMessage", EVENT);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", EVENT);

}
