
package model;

import model.type.ThreadJfrType;
import model.type.longJfrType;

public class SafepointCleanup {

    public final static String EVENT = "jdk.SafepointCleanup";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", EVENT);

}
