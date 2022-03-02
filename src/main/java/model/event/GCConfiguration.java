
package model.event;

import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCConfiguration {

    public final static String EVENT = "jdk.GCConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType YOUNG_COLLECTOR = new StringJfrType("youngCollector", EVENT);
    public final static StringJfrType OLD_COLLECTOR = new StringJfrType("oldCollector", EVENT);
    public final static intJfrType PARALLEL_G_C_THREADS = new intJfrType("parallelGCThreads", EVENT);
    public final static intJfrType CONCURRENT_G_C_THREADS = new intJfrType("concurrentGCThreads", EVENT);
    public final static booleanJfrType USES_DYNAMIC_G_C_THREADS = new booleanJfrType("usesDynamicGCThreads", EVENT);
    public final static booleanJfrType IS_EXPLICIT_G_C_CONCURRENT = new booleanJfrType("isExplicitGCConcurrent", EVENT);
    public final static booleanJfrType IS_EXPLICIT_G_C_DISABLED = new booleanJfrType("isExplicitGCDisabled", EVENT);
    public final static longJfrType PAUSE_TARGET = new longJfrType("pauseTarget", EVENT);
    public final static intJfrType GC_TIME_RATIO = new intJfrType("gcTimeRatio", EVENT);

}
