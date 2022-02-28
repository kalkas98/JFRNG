
package model;


public class SafepointCleanupTask {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField SAFEPOINT_ID = new JfrField("safepointId", "long");
    public final static JfrField NAME = new JfrField("name", "String");

}
