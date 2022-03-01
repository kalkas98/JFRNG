
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class OldGarbageCollection {

    public final static String EVENT = "jdk.OldGarbageCollection";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);

}
