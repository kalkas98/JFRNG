
package model.event;

import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class SafepointStateSynchronization {

    public final static String EVENT = "jdk.SafepointStateSynchronization";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", EVENT);
    public final static intJfrType INITIAL_THREAD_COUNT = new intJfrType("initialThreadCount", EVENT);
    public final static intJfrType RUNNING_THREAD_COUNT = new intJfrType("runningThreadCount", EVENT);
    public final static intJfrType ITERATIONS = new intJfrType("iterations", EVENT);

}
