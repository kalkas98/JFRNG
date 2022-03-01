
package model;

import model.type.booleanJfrType;
import model.type.longJfrType;

public class CPUTimeStampCounter {

    public final static String EVENT = "jdk.CPUTimeStampCounter";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static booleanJfrType FAST_TIME_ENABLED = new booleanJfrType("fastTimeEnabled", EVENT);
    public final static booleanJfrType FAST_TIME_AUTO_ENABLED = new booleanJfrType("fastTimeAutoEnabled", EVENT);
    public final static longJfrType OS_FREQUENCY = new longJfrType("osFrequency", EVENT);
    public final static longJfrType FAST_TIME_FREQUENCY = new longJfrType("fastTimeFrequency", EVENT);

}
