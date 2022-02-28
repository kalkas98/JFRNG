
package model;


public class ExecutionSample {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField SAMPLED_THREAD = new JfrField("sampledThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField STATE = new JfrField("state", "String");

}
