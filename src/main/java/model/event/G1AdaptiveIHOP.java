
package model.event;

import model.type.booleanJfrType;
import model.type.doubleJfrType;
import model.type.floatJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1AdaptiveIHOP {

    public final static String EVENT = "jdk.G1AdaptiveIHOP";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static longJfrType THRESHOLD = new longJfrType("threshold", EVENT);
    public final static floatJfrType THRESHOLD_PERCENTAGE = new floatJfrType("thresholdPercentage", EVENT);
    public final static longJfrType IHOP_TARGET_OCCUPANCY = new longJfrType("ihopTargetOccupancy", EVENT);
    public final static longJfrType CURRENT_OCCUPANCY = new longJfrType("currentOccupancy", EVENT);
    public final static longJfrType ADDITIONAL_BUFFER_SIZE = new longJfrType("additionalBufferSize", EVENT);
    public final static doubleJfrType PREDICTED_ALLOCATION_RATE = new doubleJfrType("predictedAllocationRate", EVENT);
    public final static longJfrType PREDICTED_MARKING_DURATION = new longJfrType("predictedMarkingDuration", EVENT);
    public final static booleanJfrType PREDICTION_ACTIVE = new booleanJfrType("predictionActive", EVENT);

}
