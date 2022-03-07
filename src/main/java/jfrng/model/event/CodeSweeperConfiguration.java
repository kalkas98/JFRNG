
package jfrng.model.event;

import jfrng.model.type.booleanJfrType;
import jfrng.model.type.longJfrType;

public class CodeSweeperConfiguration {

    public final static String EVENT = "jdk.CodeSweeperConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static booleanJfrType SWEEPER_ENABLED = new booleanJfrType("sweeperEnabled", EVENT);
    public final static booleanJfrType FLUSHING_ENABLED = new booleanJfrType("flushingEnabled", EVENT);
    public final static longJfrType SWEEP_THRESHOLD = new longJfrType("sweepThreshold", EVENT);

}
