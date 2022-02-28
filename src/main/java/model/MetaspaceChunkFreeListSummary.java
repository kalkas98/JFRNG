
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class MetaspaceChunkFreeListSummary {

    public final static String eventName = "jdk.MetaspaceChunkFreeListSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static StringJfrType WHEN = new StringJfrType("when", eventName);
    public final static StringJfrType METADATA_TYPE = new StringJfrType("metadataType", eventName);
    public final static longJfrType SPECIALIZED_CHUNKS = new longJfrType("specializedChunks", eventName);
    public final static longJfrType SPECIALIZED_CHUNKS_TOTAL_SIZE = new longJfrType("specializedChunksTotalSize", eventName);
    public final static longJfrType SMALL_CHUNKS = new longJfrType("smallChunks", eventName);
    public final static longJfrType SMALL_CHUNKS_TOTAL_SIZE = new longJfrType("smallChunksTotalSize", eventName);
    public final static longJfrType MEDIUM_CHUNKS = new longJfrType("mediumChunks", eventName);
    public final static longJfrType MEDIUM_CHUNKS_TOTAL_SIZE = new longJfrType("mediumChunksTotalSize", eventName);
    public final static longJfrType HUMONGOUS_CHUNKS = new longJfrType("humongousChunks", eventName);
    public final static longJfrType HUMONGOUS_CHUNKS_TOTAL_SIZE = new longJfrType("humongousChunksTotalSize", eventName);

}
