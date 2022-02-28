
package model;

import model.type.ClassLoaderJfrType;
import model.type.longJfrType;

public class ClassLoaderStatistics {

    public final static String eventName = "jdk.ClassLoaderStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ClassLoaderJfrType CLASS_LOADER = new ClassLoaderJfrType("classLoader", eventName);
    public final static ClassLoaderJfrType PARENT_CLASS_LOADER = new ClassLoaderJfrType("parentClassLoader", eventName);
    public final static longJfrType CLASS_LOADER_DATA = new longJfrType("classLoaderData", eventName);
    public final static longJfrType CLASS_COUNT = new longJfrType("classCount", eventName);
    public final static longJfrType CHUNK_SIZE = new longJfrType("chunkSize", eventName);
    public final static longJfrType BLOCK_SIZE = new longJfrType("blockSize", eventName);
    public final static longJfrType HIDDEN_CLASS_COUNT = new longJfrType("hiddenClassCount", eventName);
    public final static longJfrType HIDDEN_CHUNK_SIZE = new longJfrType("hiddenChunkSize", eventName);
    public final static longJfrType HIDDEN_BLOCK_SIZE = new longJfrType("hiddenBlockSize", eventName);

}
