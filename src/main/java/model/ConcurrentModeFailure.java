
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class ConcurrentModeFailure {

    public final static String eventName = "jdk.ConcurrentModeFailure";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);

}
