
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class GarbageCollection {

    public final static String EVENT = "jdk.GarbageCollection";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static StringJfrType CAUSE = new StringJfrType("cause", EVENT);
    public final static longJfrType SUM_OF_PAUSES = new longJfrType("sumOfPauses", EVENT);
    public final static longJfrType LONGEST_PAUSE = new longJfrType("longestPause", EVENT);

}
