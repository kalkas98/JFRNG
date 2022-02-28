
package model;


public class RetransformClasses {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField CLASS_COUNT = new JfrField("classCount", "int");
    public final static JfrField REDEFINITION_ID = new JfrField("redefinitionId", "long");

}
