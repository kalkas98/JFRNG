
package jfrng.model.event;

import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class G1MMU {

    public final static String EVENT = "jdk.G1MMU";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static longJfrType TIME_SLICE = new longJfrType("timeSlice", EVENT);
    public final static longJfrType GC_TIME = new longJfrType("gcTime", EVENT);
    public final static longJfrType PAUSE_TARGET = new longJfrType("pauseTarget", EVENT);

}
