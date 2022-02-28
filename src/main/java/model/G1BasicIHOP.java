
package model;

import model.type.doubleJfrType;
import model.type.floatJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1BasicIHOP {

    public final static String eventName = "jdk.G1BasicIHOP";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static longJfrType THRESHOLD = new longJfrType("threshold", eventName);
    public final static floatJfrType THRESHOLD_PERCENTAGE = new floatJfrType("thresholdPercentage", eventName);
    public final static longJfrType TARGET_OCCUPANCY = new longJfrType("targetOccupancy", eventName);
    public final static longJfrType CURRENT_OCCUPANCY = new longJfrType("currentOccupancy", eventName);
    public final static longJfrType RECENT_MUTATOR_ALLOCATION_SIZE = new longJfrType("recentMutatorAllocationSize", eventName);
    public final static longJfrType RECENT_MUTATOR_DURATION = new longJfrType("recentMutatorDuration", eventName);
    public final static doubleJfrType RECENT_ALLOCATION_RATE = new doubleJfrType("recentAllocationRate", eventName);
    public final static longJfrType LAST_MARKING_DURATION = new longJfrType("lastMarkingDuration", eventName);

}
