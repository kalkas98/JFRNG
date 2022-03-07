
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class G1HeapSummary {

    public final static String EVENT = "jdk.G1HeapSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType WHEN = new StringJfrType("when", EVENT);
    public final static longJfrType EDEN_USED_SIZE = new longJfrType("edenUsedSize", EVENT);
    public final static longJfrType EDEN_TOTAL_SIZE = new longJfrType("edenTotalSize", EVENT);
    public final static longJfrType SURVIVOR_USED_SIZE = new longJfrType("survivorUsedSize", EVENT);
    public final static intJfrType NUMBER_OF_REGIONS = new intJfrType("numberOfRegions", EVENT);

}
