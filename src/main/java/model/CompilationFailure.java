
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CompilationFailure {

    public final static String eventName = "jdk.CompilationFailure";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StringJfrType FAILURE_MESSAGE = new StringJfrType("failureMessage", eventName);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", eventName);

}
