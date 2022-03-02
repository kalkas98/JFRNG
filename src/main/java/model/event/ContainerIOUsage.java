
package model.event;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerIOUsage {

    public final static String EVENT = "jdk.ContainerIOUsage";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType SERVICE_REQUESTS = new longJfrType("serviceRequests", EVENT);
    public final static longJfrType DATA_TRANSFERRED = new longJfrType("dataTransferred", EVENT);

}
