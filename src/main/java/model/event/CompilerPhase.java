
package model.event;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;
import model.type.shortJfrType;

public class CompilerPhase {

    public final static String EVENT = "jdk.CompilerPhase";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType PHASE = new StringJfrType("phase", EVENT);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", EVENT);
    public final static shortJfrType PHASE_LEVEL = new shortJfrType("phaseLevel", EVENT);

}
