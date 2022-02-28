
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class ParallelOldGarbageCollection {

    public final static String eventName = "jdk.ParallelOldGarbageCollection";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static longJfrType DENSE_PREFIX = new longJfrType("densePrefix", eventName);

}
