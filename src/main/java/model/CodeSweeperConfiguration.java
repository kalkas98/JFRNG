
package model;


public class CodeSweeperConfiguration {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField SWEEPER_ENABLED = new JfrField("sweeperEnabled", "boolean");
    public final static JfrField FLUSHING_ENABLED = new JfrField("flushingEnabled", "boolean");
    public final static JfrField SWEEP_THRESHOLD = new JfrField("sweepThreshold", "long");

}
