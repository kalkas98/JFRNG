
package model;

import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCConfiguration {

    public final static String eventName = "jdk.GCConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType YOUNG_COLLECTOR = new StringJfrType("youngCollector", eventName);
    public final static StringJfrType OLD_COLLECTOR = new StringJfrType("oldCollector", eventName);
    public final static intJfrType PARALLEL_G_C_THREADS = new intJfrType("parallelGCThreads", eventName);
    public final static intJfrType CONCURRENT_G_C_THREADS = new intJfrType("concurrentGCThreads", eventName);
    public final static booleanJfrType USES_DYNAMIC_G_C_THREADS = new booleanJfrType("usesDynamicGCThreads", eventName);
    public final static booleanJfrType IS_EXPLICIT_G_C_CONCURRENT = new booleanJfrType("isExplicitGCConcurrent", eventName);
    public final static booleanJfrType IS_EXPLICIT_G_C_DISABLED = new booleanJfrType("isExplicitGCDisabled", eventName);
    public final static longJfrType PAUSE_TARGET = new longJfrType("pauseTarget", eventName);
    public final static intJfrType GC_TIME_RATIO = new intJfrType("gcTimeRatio", eventName);

}
