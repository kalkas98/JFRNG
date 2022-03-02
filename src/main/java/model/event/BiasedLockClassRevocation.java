
package model.event;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class BiasedLockClassRevocation {

    public final static String EVENT = "jdk.BiasedLockClassRevocation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassJfrType REVOKED_CLASS = new ClassJfrType("revokedClass", EVENT);
    public final static booleanJfrType DISABLE_BIASING = new booleanJfrType("disableBiasing", EVENT);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", EVENT);

}
