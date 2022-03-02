
package model.event;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class SafepointCleanupTask {

    public final static String EVENT = "jdk.SafepointCleanupTask";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);

}
