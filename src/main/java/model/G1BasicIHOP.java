
package model;


public class G1BasicIHOP {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField THRESHOLD = new JfrField("threshold", "long");
    public final static JfrField THRESHOLD_PERCENTAGE = new JfrField("thresholdPercentage", "float");
    public final static JfrField TARGET_OCCUPANCY = new JfrField("targetOccupancy", "long");
    public final static JfrField CURRENT_OCCUPANCY = new JfrField("currentOccupancy", "long");
    public final static JfrField RECENT_MUTATOR_ALLOCATION_SIZE = new JfrField("recentMutatorAllocationSize", "long");
    public final static JfrField RECENT_MUTATOR_DURATION = new JfrField("recentMutatorDuration", "long");
    public final static JfrField RECENT_ALLOCATION_RATE = new JfrField("recentAllocationRate", "double");
    public final static JfrField LAST_MARKING_DURATION = new JfrField("lastMarkingDuration", "long");

}
