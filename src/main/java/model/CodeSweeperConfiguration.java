
package model;

import model.type.booleanJfrType;
import model.type.longJfrType;

public class CodeSweeperConfiguration {

    public final static String eventName = "jdk.CodeSweeperConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static booleanJfrType SWEEPER_ENABLED = new booleanJfrType("sweeperEnabled", eventName);
    public final static booleanJfrType FLUSHING_ENABLED = new booleanJfrType("flushingEnabled", eventName);
    public final static longJfrType SWEEP_THRESHOLD = new longJfrType("sweepThreshold", eventName);

}
