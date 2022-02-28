
package model;


public class CodeSweeperStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField SWEEP_COUNT = new JfrField("sweepCount", "int");
    public final static JfrField METHOD_RECLAIMED_COUNT = new JfrField("methodReclaimedCount", "int");
    public final static JfrField TOTAL_SWEEP_TIME = new JfrField("totalSweepTime", "long");
    public final static JfrField PEAK_FRACTION_TIME = new JfrField("peakFractionTime", "long");
    public final static JfrField PEAK_SWEEP_TIME = new JfrField("peakSweepTime", "long");

}
