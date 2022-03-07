
package jfrng.model.event;

import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class EvacuationInformation {

    public final static String EVENT = "jdk.EvacuationInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static intJfrType C_SET_REGIONS = new intJfrType("cSetRegions", EVENT);
    public final static longJfrType C_SET_USED_BEFORE = new longJfrType("cSetUsedBefore", EVENT);
    public final static longJfrType C_SET_USED_AFTER = new longJfrType("cSetUsedAfter", EVENT);
    public final static intJfrType ALLOCATION_REGIONS = new intJfrType("allocationRegions", EVENT);
    public final static longJfrType ALLOCATION_REGIONS_USED_BEFORE = new longJfrType("allocationRegionsUsedBefore", EVENT);
    public final static longJfrType ALLOCATION_REGIONS_USED_AFTER = new longJfrType("allocationRegionsUsedAfter", EVENT);
    public final static longJfrType BYTES_COPIED = new longJfrType("bytesCopied", EVENT);
    public final static intJfrType REGIONS_FREED = new intJfrType("regionsFreed", EVENT);

}
