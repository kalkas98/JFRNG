
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class EvacuationInformation {

    public final static String eventName = "jdk.EvacuationInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static intJfrType C_SET_REGIONS = new intJfrType("cSetRegions", eventName);
    public final static longJfrType C_SET_USED_BEFORE = new longJfrType("cSetUsedBefore", eventName);
    public final static longJfrType C_SET_USED_AFTER = new longJfrType("cSetUsedAfter", eventName);
    public final static intJfrType ALLOCATION_REGIONS = new intJfrType("allocationRegions", eventName);
    public final static longJfrType ALLOCATION_REGIONS_USED_BEFORE = new longJfrType("allocationRegionsUsedBefore", eventName);
    public final static longJfrType ALLOCATION_REGIONS_USED_AFTER = new longJfrType("allocationRegionsUsedAfter", eventName);
    public final static longJfrType BYTES_COPIED = new longJfrType("bytesCopied", eventName);
    public final static intJfrType REGIONS_FREED = new intJfrType("regionsFreed", eventName);

}
