
package jfrng.model.event;

import jfrng.model.type.floatJfrType;
import jfrng.model.type.longJfrType;

public class ThreadContextSwitchRate {

    public final static String EVENT = "jdk.ThreadContextSwitchRate";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static floatJfrType SWITCH_RATE = new floatJfrType("switchRate", EVENT);

}
