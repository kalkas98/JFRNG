
package model;


public class ThreadStart {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField THREAD = new JfrField("thread", "Thread");
    public final static JfrField PARENT_THREAD = new JfrField("parentThread", "Thread");

}
