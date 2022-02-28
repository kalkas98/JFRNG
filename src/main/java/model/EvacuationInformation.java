
package model;


public class EvacuationInformation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField C_SET_REGIONS = new JfrField("cSetRegions", "int");
    public final static JfrField C_SET_USED_BEFORE = new JfrField("cSetUsedBefore", "long");
    public final static JfrField C_SET_USED_AFTER = new JfrField("cSetUsedAfter", "long");
    public final static JfrField ALLOCATION_REGIONS = new JfrField("allocationRegions", "int");
    public final static JfrField ALLOCATION_REGIONS_USED_BEFORE = new JfrField("allocationRegionsUsedBefore", "long");
    public final static JfrField ALLOCATION_REGIONS_USED_AFTER = new JfrField("allocationRegionsUsedAfter", "long");
    public final static JfrField BYTES_COPIED = new JfrField("bytesCopied", "long");
    public final static JfrField REGIONS_FREED = new JfrField("regionsFreed", "int");

}
