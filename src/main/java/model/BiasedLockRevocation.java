
package model;


public class BiasedLockRevocation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField LOCK_CLASS = new JfrField("lockClass", "Class");
    public final static JfrField SAFEPOINT_ID = new JfrField("safepointId", "long");
    public final static JfrField PREVIOUS_OWNER = new JfrField("previousOwner", "Thread");

}
