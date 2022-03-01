
package model;

import model.type.StringJfrType;
import model.type.VirtualSpaceJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCHeapSummary {

    public final static String EVENT = "jdk.GCHeapSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType WHEN = new StringJfrType("when", EVENT);
    public final static VirtualSpaceJfrType HEAP_SPACE = new VirtualSpaceJfrType("heapSpace", EVENT);
    public final static longJfrType HEAP_USED = new longJfrType("heapUsed", EVENT);

}
