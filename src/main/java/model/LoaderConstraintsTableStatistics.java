
package model;

import model.type.floatJfrType;
import model.type.longJfrType;

public class LoaderConstraintsTableStatistics {

    public final static String eventName = "jdk.LoaderConstraintsTableStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType BUCKET_COUNT = new longJfrType("bucketCount", eventName);
    public final static longJfrType ENTRY_COUNT = new longJfrType("entryCount", eventName);
    public final static longJfrType TOTAL_FOOTPRINT = new longJfrType("totalFootprint", eventName);
    public final static longJfrType BUCKET_COUNT_MAXIMUM = new longJfrType("bucketCountMaximum", eventName);
    public final static floatJfrType BUCKET_COUNT_AVERAGE = new floatJfrType("bucketCountAverage", eventName);
    public final static floatJfrType BUCKET_COUNT_VARIANCE = new floatJfrType("bucketCountVariance", eventName);
    public final static floatJfrType BUCKET_COUNT_STANDARD_DEVIATION = new floatJfrType("bucketCountStandardDeviation", eventName);
    public final static floatJfrType INSERTION_RATE = new floatJfrType("insertionRate", eventName);
    public final static floatJfrType REMOVAL_RATE = new floatJfrType("removalRate", eventName);

}
