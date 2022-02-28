
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GarbageCollection {

    public final static String eventName = "jdk.GarbageCollection";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static StringJfrType CAUSE = new StringJfrType("cause", eventName);
    public final static longJfrType SUM_OF_PAUSES = new longJfrType("sumOfPauses", eventName);
    public final static longJfrType LONGEST_PAUSE = new longJfrType("longestPause", eventName);

}
