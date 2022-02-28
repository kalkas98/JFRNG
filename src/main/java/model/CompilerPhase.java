
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;
import model.type.shortJfrType;

public class CompilerPhase {

    public final static String eventName = "jdk.CompilerPhase";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StringJfrType PHASE = new StringJfrType("phase", eventName);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", eventName);
    public final static shortJfrType PHASE_LEVEL = new shortJfrType("phaseLevel", eventName);

}
