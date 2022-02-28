
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class SafepointCleanupTask {

    public final static String eventName = "jdk.SafepointCleanupTask";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);

}
