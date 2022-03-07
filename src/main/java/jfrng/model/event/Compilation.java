
package jfrng.model.event;

import jfrng.model.type.MethodJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;
import jfrng.model.type.shortJfrType;

public class Compilation {

    public final static String EVENT = "jdk.Compilation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", EVENT);
    public final static StringJfrType COMPILER = new StringJfrType("compiler", EVENT);
    public final static MethodJfrType METHOD = new MethodJfrType("method", EVENT);
    public final static shortJfrType COMPILE_LEVEL = new shortJfrType("compileLevel", EVENT);
    public final static booleanJfrType SUCCEDED = new booleanJfrType("succeded", EVENT);
    public final static booleanJfrType IS_OSR = new booleanJfrType("isOsr", EVENT);
    public final static longJfrType CODE_SIZE = new longJfrType("codeSize", EVENT);
    public final static longJfrType INLINED_BYTES = new longJfrType("inlinedBytes", EVENT);

}
