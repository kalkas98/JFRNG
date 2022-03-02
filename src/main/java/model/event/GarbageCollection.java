
package model.event;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

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
