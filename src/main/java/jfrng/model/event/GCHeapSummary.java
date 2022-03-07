
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.VirtualSpaceJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class GCHeapSummary {

    public final static String EVENT = "jdk.GCHeapSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType WHEN = new StringJfrType("when", EVENT);
    public final static VirtualSpaceJfrType HEAP_SPACE = new VirtualSpaceJfrType("heapSpace", EVENT);
    public final static longJfrType HEAP_USED = new longJfrType("heapUsed", EVENT);

}
