
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class BiasedLockClassRevocation {

    public final static String eventName = "jdk.BiasedLockClassRevocation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ClassJfrType REVOKED_CLASS = new ClassJfrType("revokedClass", eventName);
    public final static booleanJfrType DISABLE_BIASING = new booleanJfrType("disableBiasing", eventName);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", eventName);

}
