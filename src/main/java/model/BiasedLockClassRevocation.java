
package model;


public class BiasedLockClassRevocation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField REVOKED_CLASS = new JfrField("revokedClass", "Class");
    public final static JfrField DISABLE_BIASING = new JfrField("disableBiasing", "boolean");
    public final static JfrField SAFEPOINT_ID = new JfrField("safepointId", "long");

}
