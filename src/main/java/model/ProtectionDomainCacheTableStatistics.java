
package model;


public class ProtectionDomainCacheTableStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField BUCKET_COUNT = new JfrField("bucketCount", "long");
    public final static JfrField ENTRY_COUNT = new JfrField("entryCount", "long");
    public final static JfrField TOTAL_FOOTPRINT = new JfrField("totalFootprint", "long");
    public final static JfrField BUCKET_COUNT_MAXIMUM = new JfrField("bucketCountMaximum", "long");
    public final static JfrField BUCKET_COUNT_AVERAGE = new JfrField("bucketCountAverage", "float");
    public final static JfrField BUCKET_COUNT_VARIANCE = new JfrField("bucketCountVariance", "float");
    public final static JfrField BUCKET_COUNT_STANDARD_DEVIATION = new JfrField("bucketCountStandardDeviation", "float");
    public final static JfrField INSERTION_RATE = new JfrField("insertionRate", "float");
    public final static JfrField REMOVAL_RATE = new JfrField("removalRate", "float");

}
