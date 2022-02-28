
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class CodeSweeperStatistics {

    public final static String eventName = "jdk.CodeSweeperStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType SWEEP_COUNT = new intJfrType("sweepCount", eventName);
    public final static intJfrType METHOD_RECLAIMED_COUNT = new intJfrType("methodReclaimedCount", eventName);
    public final static longJfrType TOTAL_SWEEP_TIME = new longJfrType("totalSweepTime", eventName);
    public final static longJfrType PEAK_FRACTION_TIME = new longJfrType("peakFractionTime", eventName);
    public final static longJfrType PEAK_SWEEP_TIME = new longJfrType("peakSweepTime", eventName);

}
