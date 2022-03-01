
package model;

import model.type.ClassLoaderJfrType;
import model.type.longJfrType;

public class ClassLoaderStatistics {

    public final static String EVENT = "jdk.ClassLoaderStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ClassLoaderJfrType CLASS_LOADER = new ClassLoaderJfrType("classLoader", EVENT);
    public final static ClassLoaderJfrType PARENT_CLASS_LOADER = new ClassLoaderJfrType("parentClassLoader", EVENT);
    public final static longJfrType CLASS_LOADER_DATA = new longJfrType("classLoaderData", EVENT);
    public final static longJfrType CLASS_COUNT = new longJfrType("classCount", EVENT);
    public final static longJfrType CHUNK_SIZE = new longJfrType("chunkSize", EVENT);
    public final static longJfrType BLOCK_SIZE = new longJfrType("blockSize", EVENT);
    public final static longJfrType HIDDEN_CLASS_COUNT = new longJfrType("hiddenClassCount", EVENT);
    public final static longJfrType HIDDEN_CHUNK_SIZE = new longJfrType("hiddenChunkSize", EVENT);
    public final static longJfrType HIDDEN_BLOCK_SIZE = new longJfrType("hiddenBlockSize", EVENT);

}
