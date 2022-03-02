
package model.event;

import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class SafepointBegin {

    public final static String EVENT = "jdk.SafepointBegin";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", EVENT);
    public final static intJfrType TOTAL_THREAD_COUNT = new intJfrType("totalThreadCount", EVENT);
    public final static intJfrType JNI_CRITICAL_THREAD_COUNT = new intJfrType("jniCriticalThreadCount", EVENT);

}
