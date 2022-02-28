
package model;


public class ContainerIOUsage {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField SERVICE_REQUESTS = new JfrField("serviceRequests", "long");
    public final static JfrField DATA_TRANSFERRED = new JfrField("dataTransferred", "long");

}
