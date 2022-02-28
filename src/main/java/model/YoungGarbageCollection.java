
package model;


public class YoungGarbageCollection {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField TENURING_THRESHOLD = new JfrField("tenuringThreshold", "int");

}
