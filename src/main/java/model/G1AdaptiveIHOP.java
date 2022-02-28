
package model;


public class G1AdaptiveIHOP {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField THRESHOLD = new JfrField("threshold", "long");
    public final static JfrField THRESHOLD_PERCENTAGE = new JfrField("thresholdPercentage", "float");
    public final static JfrField IHOP_TARGET_OCCUPANCY = new JfrField("ihopTargetOccupancy", "long");
    public final static JfrField CURRENT_OCCUPANCY = new JfrField("currentOccupancy", "long");
    public final static JfrField ADDITIONAL_BUFFER_SIZE = new JfrField("additionalBufferSize", "long");
    public final static JfrField PREDICTED_ALLOCATION_RATE = new JfrField("predictedAllocationRate", "double");
    public final static JfrField PREDICTED_MARKING_DURATION = new JfrField("predictedMarkingDuration", "long");
    public final static JfrField PREDICTION_ACTIVE = new JfrField("predictionActive", "boolean");

}
