
package model.event;

import model.type.intJfrType;
import model.type.longJfrType;

public class CodeSweeperStatistics {

    public final static String EVENT = "jdk.CodeSweeperStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType SWEEP_COUNT = new intJfrType("sweepCount", EVENT);
    public final static intJfrType METHOD_RECLAIMED_COUNT = new intJfrType("methodReclaimedCount", EVENT);
    public final static longJfrType TOTAL_SWEEP_TIME = new longJfrType("totalSweepTime", EVENT);
    public final static longJfrType PEAK_FRACTION_TIME = new longJfrType("peakFractionTime", EVENT);
    public final static longJfrType PEAK_SWEEP_TIME = new longJfrType("peakSweepTime", EVENT);

}
