
package model;


public class GCPhasePause {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField NAME = new JfrField("name", "String");

}
