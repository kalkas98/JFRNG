
package model;


public class SafepointStateSynchronization {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField SAFEPOINT_ID = new JfrField("safepointId", "long");
    public final static JfrField INITIAL_THREAD_COUNT = new JfrField("initialThreadCount", "int");
    public final static JfrField RUNNING_THREAD_COUNT = new JfrField("runningThreadCount", "int");
    public final static JfrField ITERATIONS = new JfrField("iterations", "int");

}
