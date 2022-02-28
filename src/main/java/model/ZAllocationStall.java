
package model;


public class ZAllocationStall {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField TYPE = new JfrField("type", "String");
    public final static JfrField SIZE = new JfrField("size", "long");

}
