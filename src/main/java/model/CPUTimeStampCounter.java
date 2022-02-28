
package model;

import model.type.booleanJfrType;
import model.type.longJfrType;

public class CPUTimeStampCounter {

    public final static String eventName = "jdk.CPUTimeStampCounter";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static booleanJfrType FAST_TIME_ENABLED = new booleanJfrType("fastTimeEnabled", eventName);
    public final static booleanJfrType FAST_TIME_AUTO_ENABLED = new booleanJfrType("fastTimeAutoEnabled", eventName);
    public final static longJfrType OS_FREQUENCY = new longJfrType("osFrequency", eventName);
    public final static longJfrType FAST_TIME_FREQUENCY = new longJfrType("fastTimeFrequency", eventName);

}
