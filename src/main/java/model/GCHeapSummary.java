
package model;


public class GCHeapSummary {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField WHEN = new JfrField("when", "String");
    public final static JfrField HEAP_SPACE = new JfrField("heapSpace", "VirtualSpace");
    public final static JfrField HEAP_USED = new JfrField("heapUsed", "long");

}
