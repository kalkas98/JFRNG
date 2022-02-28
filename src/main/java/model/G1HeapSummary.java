
package model;


public class G1HeapSummary {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField WHEN = new JfrField("when", "String");
    public final static JfrField EDEN_USED_SIZE = new JfrField("edenUsedSize", "long");
    public final static JfrField EDEN_TOTAL_SIZE = new JfrField("edenTotalSize", "long");
    public final static JfrField SURVIVOR_USED_SIZE = new JfrField("survivorUsedSize", "long");
    public final static JfrField NUMBER_OF_REGIONS = new JfrField("numberOfRegions", "int");

}
