
package model;

import model.type.longJfrType;

public class JavaThreadStatistics {

    public final static String EVENT = "jdk.JavaThreadStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType ACTIVE_COUNT = new longJfrType("activeCount", EVENT);
    public final static longJfrType DAEMON_COUNT = new longJfrType("daemonCount", EVENT);
    public final static longJfrType ACCUMULATED_COUNT = new longJfrType("accumulatedCount", EVENT);
    public final static longJfrType PEAK_COUNT = new longJfrType("peakCount", EVENT);

}
