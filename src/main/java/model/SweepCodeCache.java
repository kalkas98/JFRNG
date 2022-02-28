
package model;


public class SweepCodeCache {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField SWEEP_ID = new JfrField("sweepId", "int");
    public final static JfrField SWEPT_COUNT = new JfrField("sweptCount", "int");
    public final static JfrField FLUSHED_COUNT = new JfrField("flushedCount", "int");
    public final static JfrField ZOMBIFIED_COUNT = new JfrField("zombifiedCount", "int");

}
