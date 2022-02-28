
package model;

import model.type.CopyFailedJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class EvacuationFailed {

    public final static String eventName = "jdk.EvacuationFailed";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static CopyFailedJfrType EVACUATION_FAILED = new CopyFailedJfrType("evacuationFailed", eventName);

}
