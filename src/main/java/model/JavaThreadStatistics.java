
package model;


public class JavaThreadStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField ACTIVE_COUNT = new JfrField("activeCount", "long");
    public final static JfrField DAEMON_COUNT = new JfrField("daemonCount", "long");
    public final static JfrField ACCUMULATED_COUNT = new JfrField("accumulatedCount", "long");
    public final static JfrField PEAK_COUNT = new JfrField("peakCount", "long");

}
