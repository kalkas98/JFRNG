
package model;


public class ThreadPark {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField PARKED_CLASS = new JfrField("parkedClass", "Class");
    public final static JfrField TIMEOUT = new JfrField("timeout", "long");
    public final static JfrField UNTIL = new JfrField("until", "long");
    public final static JfrField ADDRESS = new JfrField("address", "long");

}
