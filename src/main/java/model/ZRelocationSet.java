
package model;


public class ZRelocationSet {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField TOTAL = new JfrField("total", "long");
    public final static JfrField EMPTY = new JfrField("empty", "long");
    public final static JfrField RELOCATE = new JfrField("relocate", "long");

}
