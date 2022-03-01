
package model;

import model.type.CopyFailedJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class EvacuationFailed {

    public final static String EVENT = "jdk.EvacuationFailed";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static CopyFailedJfrType EVACUATION_FAILED = new CopyFailedJfrType("evacuationFailed", EVENT);

}
