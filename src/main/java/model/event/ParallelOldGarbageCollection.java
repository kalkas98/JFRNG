
package model.event;

import model.type.intJfrType;
import model.type.longJfrType;

public class ParallelOldGarbageCollection {

    public final static String EVENT = "jdk.ParallelOldGarbageCollection";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static longJfrType DENSE_PREFIX = new longJfrType("densePrefix", EVENT);

}
