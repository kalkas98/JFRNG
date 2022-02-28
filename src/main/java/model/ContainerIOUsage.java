
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ContainerIOUsage {

    public final static String eventName = "jdk.ContainerIOUsage";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType SERVICE_REQUESTS = new longJfrType("serviceRequests", eventName);
    public final static longJfrType DATA_TRANSFERRED = new longJfrType("dataTransferred", eventName);

}
