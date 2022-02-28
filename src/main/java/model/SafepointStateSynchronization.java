
package model;

import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class SafepointStateSynchronization {

    public final static String eventName = "jdk.SafepointStateSynchronization";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", eventName);
    public final static intJfrType INITIAL_THREAD_COUNT = new intJfrType("initialThreadCount", eventName);
    public final static intJfrType RUNNING_THREAD_COUNT = new intJfrType("runningThreadCount", eventName);
    public final static intJfrType ITERATIONS = new intJfrType("iterations", eventName);

}
