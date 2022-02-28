
package model;

import model.type.StringJfrType;
import model.type.VirtualSpaceJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCHeapSummary {

    public final static String eventName = "jdk.GCHeapSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static StringJfrType WHEN = new StringJfrType("when", eventName);
    public final static VirtualSpaceJfrType HEAP_SPACE = new VirtualSpaceJfrType("heapSpace", eventName);
    public final static longJfrType HEAP_USED = new longJfrType("heapUsed", eventName);

}
