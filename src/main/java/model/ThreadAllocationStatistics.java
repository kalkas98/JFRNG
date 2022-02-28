
package model;

import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ThreadAllocationStatistics {

    public final static String eventName = "jdk.ThreadAllocationStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType ALLOCATED = new longJfrType("allocated", eventName);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", eventName);

}
