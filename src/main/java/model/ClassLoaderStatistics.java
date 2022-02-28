
package model;


public class ClassLoaderStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField CLASS_LOADER = new JfrField("classLoader", "ClassLoader");
    public final static JfrField PARENT_CLASS_LOADER = new JfrField("parentClassLoader", "ClassLoader");
    public final static JfrField CLASS_LOADER_DATA = new JfrField("classLoaderData", "long");
    public final static JfrField CLASS_COUNT = new JfrField("classCount", "long");
    public final static JfrField CHUNK_SIZE = new JfrField("chunkSize", "long");
    public final static JfrField BLOCK_SIZE = new JfrField("blockSize", "long");
    public final static JfrField HIDDEN_CLASS_COUNT = new JfrField("hiddenClassCount", "long");
    public final static JfrField HIDDEN_CHUNK_SIZE = new JfrField("hiddenChunkSize", "long");
    public final static JfrField HIDDEN_BLOCK_SIZE = new JfrField("hiddenBlockSize", "long");

}
