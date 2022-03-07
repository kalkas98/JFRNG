
package jfrng.model.event;

import jfrng.model.type.floatJfrType;
import jfrng.model.type.longJfrType;

public class StringTableStatistics {

    public final static String EVENT = "jdk.StringTableStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType BUCKET_COUNT = new longJfrType("bucketCount", EVENT);
    public final static longJfrType ENTRY_COUNT = new longJfrType("entryCount", EVENT);
    public final static longJfrType TOTAL_FOOTPRINT = new longJfrType("totalFootprint", EVENT);
    public final static longJfrType BUCKET_COUNT_MAXIMUM = new longJfrType("bucketCountMaximum", EVENT);
    public final static floatJfrType BUCKET_COUNT_AVERAGE = new floatJfrType("bucketCountAverage", EVENT);
    public final static floatJfrType BUCKET_COUNT_VARIANCE = new floatJfrType("bucketCountVariance", EVENT);
    public final static floatJfrType BUCKET_COUNT_STANDARD_DEVIATION = new floatJfrType("bucketCountStandardDeviation", EVENT);
    public final static floatJfrType INSERTION_RATE = new floatJfrType("insertionRate", EVENT);
    public final static floatJfrType REMOVAL_RATE = new floatJfrType("removalRate", EVENT);

}
