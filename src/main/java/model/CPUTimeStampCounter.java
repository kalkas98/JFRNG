
package model;


public class CPUTimeStampCounter {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField FAST_TIME_ENABLED = new JfrField("fastTimeEnabled", "boolean");
    public final static JfrField FAST_TIME_AUTO_ENABLED = new JfrField("fastTimeAutoEnabled", "boolean");
    public final static JfrField OS_FREQUENCY = new JfrField("osFrequency", "long");
    public final static JfrField FAST_TIME_FREQUENCY = new JfrField("fastTimeFrequency", "long");

}
