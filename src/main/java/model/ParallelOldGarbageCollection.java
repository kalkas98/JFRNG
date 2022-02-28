
package model;


public class ParallelOldGarbageCollection {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField DENSE_PREFIX = new JfrField("densePrefix", "long");

}
