
package model;

import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class SafepointBegin {

    public final static String eventName = "jdk.SafepointBegin";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", eventName);
    public final static intJfrType TOTAL_THREAD_COUNT = new intJfrType("totalThreadCount", eventName);
    public final static intJfrType JNI_CRITICAL_THREAD_COUNT = new intJfrType("jniCriticalThreadCount", eventName);

}
