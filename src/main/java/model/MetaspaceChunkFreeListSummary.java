
package model;


public class MetaspaceChunkFreeListSummary {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField WHEN = new JfrField("when", "String");
    public final static JfrField METADATA_TYPE = new JfrField("metadataType", "String");
    public final static JfrField SPECIALIZED_CHUNKS = new JfrField("specializedChunks", "long");
    public final static JfrField SPECIALIZED_CHUNKS_TOTAL_SIZE = new JfrField("specializedChunksTotalSize", "long");
    public final static JfrField SMALL_CHUNKS = new JfrField("smallChunks", "long");
    public final static JfrField SMALL_CHUNKS_TOTAL_SIZE = new JfrField("smallChunksTotalSize", "long");
    public final static JfrField MEDIUM_CHUNKS = new JfrField("mediumChunks", "long");
    public final static JfrField MEDIUM_CHUNKS_TOTAL_SIZE = new JfrField("mediumChunksTotalSize", "long");
    public final static JfrField HUMONGOUS_CHUNKS = new JfrField("humongousChunks", "long");
    public final static JfrField HUMONGOUS_CHUNKS_TOTAL_SIZE = new JfrField("humongousChunksTotalSize", "long");

}
