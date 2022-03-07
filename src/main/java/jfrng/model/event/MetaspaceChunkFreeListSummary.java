
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class MetaspaceChunkFreeListSummary {

    public final static String EVENT = "jdk.MetaspaceChunkFreeListSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType WHEN = new StringJfrType("when", EVENT);
    public final static StringJfrType METADATA_TYPE = new StringJfrType("metadataType", EVENT);
    public final static longJfrType SPECIALIZED_CHUNKS = new longJfrType("specializedChunks", EVENT);
    public final static longJfrType SPECIALIZED_CHUNKS_TOTAL_SIZE = new longJfrType("specializedChunksTotalSize", EVENT);
    public final static longJfrType SMALL_CHUNKS = new longJfrType("smallChunks", EVENT);
    public final static longJfrType SMALL_CHUNKS_TOTAL_SIZE = new longJfrType("smallChunksTotalSize", EVENT);
    public final static longJfrType MEDIUM_CHUNKS = new longJfrType("mediumChunks", EVENT);
    public final static longJfrType MEDIUM_CHUNKS_TOTAL_SIZE = new longJfrType("mediumChunksTotalSize", EVENT);
    public final static longJfrType HUMONGOUS_CHUNKS = new longJfrType("humongousChunks", EVENT);
    public final static longJfrType HUMONGOUS_CHUNKS_TOTAL_SIZE = new longJfrType("humongousChunksTotalSize", EVENT);

}
