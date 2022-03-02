
package model.event;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CompilationFailure {

    public final static String EVENT = "jdk.CompilationFailure";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType FAILURE_MESSAGE = new StringJfrType("failureMessage", EVENT);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", EVENT);

}
