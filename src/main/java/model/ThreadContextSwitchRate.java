
package model;

import model.type.floatJfrType;
import model.type.longJfrType;

public class ThreadContextSwitchRate {

    public final static String eventName = "jdk.ThreadContextSwitchRate";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static floatJfrType SWITCH_RATE = new floatJfrType("switchRate", eventName);

}
