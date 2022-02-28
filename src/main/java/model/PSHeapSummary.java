
package model;


public class PSHeapSummary {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField WHEN = new JfrField("when", "String");
    public final static JfrField OLD_SPACE = new JfrField("oldSpace", "VirtualSpace");
    public final static JfrField OLD_OBJECT_SPACE = new JfrField("oldObjectSpace", "ObjectSpace");
    public final static JfrField YOUNG_SPACE = new JfrField("youngSpace", "VirtualSpace");
    public final static JfrField EDEN_SPACE = new JfrField("edenSpace", "ObjectSpace");
    public final static JfrField FROM_SPACE = new JfrField("fromSpace", "ObjectSpace");
    public final static JfrField TO_SPACE = new JfrField("toSpace", "ObjectSpace");

}
