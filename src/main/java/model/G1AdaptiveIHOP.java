
package model;

import model.type.booleanJfrType;
import model.type.doubleJfrType;
import model.type.floatJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1AdaptiveIHOP {

    public final static String eventName = "jdk.G1AdaptiveIHOP";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static longJfrType THRESHOLD = new longJfrType("threshold", eventName);
    public final static floatJfrType THRESHOLD_PERCENTAGE = new floatJfrType("thresholdPercentage", eventName);
    public final static longJfrType IHOP_TARGET_OCCUPANCY = new longJfrType("ihopTargetOccupancy", eventName);
    public final static longJfrType CURRENT_OCCUPANCY = new longJfrType("currentOccupancy", eventName);
    public final static longJfrType ADDITIONAL_BUFFER_SIZE = new longJfrType("additionalBufferSize", eventName);
    public final static doubleJfrType PREDICTED_ALLOCATION_RATE = new doubleJfrType("predictedAllocationRate", eventName);
    public final static longJfrType PREDICTED_MARKING_DURATION = new longJfrType("predictedMarkingDuration", eventName);
    public final static booleanJfrType PREDICTION_ACTIVE = new booleanJfrType("predictionActive", eventName);

}
