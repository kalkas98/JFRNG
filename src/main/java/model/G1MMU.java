
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class G1MMU {

    public final static String eventName = "jdk.G1MMU";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static longJfrType TIME_SLICE = new longJfrType("timeSlice", eventName);
    public final static longJfrType GC_TIME = new longJfrType("gcTime", eventName);
    public final static longJfrType PAUSE_TARGET = new longJfrType("pauseTarget", eventName);

}
