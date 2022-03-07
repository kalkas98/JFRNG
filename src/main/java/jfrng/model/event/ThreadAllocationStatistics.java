
package jfrng.model.event;

import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ThreadAllocationStatistics {

    public final static String EVENT = "jdk.ThreadAllocationStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType ALLOCATED = new longJfrType("allocated", EVENT);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", EVENT);

}
