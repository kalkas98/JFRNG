
package model;


public class G1GarbageCollection {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField TYPE = new JfrField("type", "String");

}
