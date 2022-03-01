
package model;

import model.type.doubleJfrType;
import model.type.floatJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1BasicIHOP {

    public final static String EVENT = "jdk.G1BasicIHOP";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static longJfrType THRESHOLD = new longJfrType("threshold", EVENT);
    public final static floatJfrType THRESHOLD_PERCENTAGE = new floatJfrType("thresholdPercentage", EVENT);
    public final static longJfrType TARGET_OCCUPANCY = new longJfrType("targetOccupancy", EVENT);
    public final static longJfrType CURRENT_OCCUPANCY = new longJfrType("currentOccupancy", EVENT);
    public final static longJfrType RECENT_MUTATOR_ALLOCATION_SIZE = new longJfrType("recentMutatorAllocationSize", EVENT);
    public final static longJfrType RECENT_MUTATOR_DURATION = new longJfrType("recentMutatorDuration", EVENT);
    public final static doubleJfrType RECENT_ALLOCATION_RATE = new doubleJfrType("recentAllocationRate", EVENT);
    public final static longJfrType LAST_MARKING_DURATION = new longJfrType("lastMarkingDuration", EVENT);

}
