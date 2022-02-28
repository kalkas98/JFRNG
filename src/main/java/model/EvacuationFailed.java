
package model;


public class EvacuationFailed {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField EVACUATION_FAILED = new JfrField("evacuationFailed", "CopyFailed");

}
