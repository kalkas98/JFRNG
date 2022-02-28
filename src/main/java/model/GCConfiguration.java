
package model;


public class GCConfiguration {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField YOUNG_COLLECTOR = new JfrField("youngCollector", "String");
    public final static JfrField OLD_COLLECTOR = new JfrField("oldCollector", "String");
    public final static JfrField PARALLEL_G_C_THREADS = new JfrField("parallelGCThreads", "int");
    public final static JfrField CONCURRENT_G_C_THREADS = new JfrField("concurrentGCThreads", "int");
    public final static JfrField USES_DYNAMIC_G_C_THREADS = new JfrField("usesDynamicGCThreads", "boolean");
    public final static JfrField IS_EXPLICIT_G_C_CONCURRENT = new JfrField("isExplicitGCConcurrent", "boolean");
    public final static JfrField IS_EXPLICIT_G_C_DISABLED = new JfrField("isExplicitGCDisabled", "boolean");
    public final static JfrField PAUSE_TARGET = new JfrField("pauseTarget", "long");
    public final static JfrField GC_TIME_RATIO = new JfrField("gcTimeRatio", "int");

}
