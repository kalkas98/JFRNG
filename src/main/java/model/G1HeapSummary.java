
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1HeapSummary {

    public final static String eventName = "jdk.G1HeapSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static StringJfrType WHEN = new StringJfrType("when", eventName);
    public final static longJfrType EDEN_USED_SIZE = new longJfrType("edenUsedSize", eventName);
    public final static longJfrType EDEN_TOTAL_SIZE = new longJfrType("edenTotalSize", eventName);
    public final static longJfrType SURVIVOR_USED_SIZE = new longJfrType("survivorUsedSize", eventName);
    public final static intJfrType NUMBER_OF_REGIONS = new intJfrType("numberOfRegions", eventName);

}
