
package model;

import model.type.longJfrType;

public class JavaThreadStatistics {

    public final static String eventName = "jdk.JavaThreadStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType ACTIVE_COUNT = new longJfrType("activeCount", eventName);
    public final static longJfrType DAEMON_COUNT = new longJfrType("daemonCount", eventName);
    public final static longJfrType ACCUMULATED_COUNT = new longJfrType("accumulatedCount", eventName);
    public final static longJfrType PEAK_COUNT = new longJfrType("peakCount", eventName);

}
