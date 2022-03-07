
package jfrng.model.event;

import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class ConcurrentModeFailure {

    public final static String EVENT = "jdk.ConcurrentModeFailure";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);

}
