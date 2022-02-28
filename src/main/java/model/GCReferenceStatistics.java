
package model;


public class GCReferenceStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField TYPE = new JfrField("type", "String");
    public final static JfrField COUNT = new JfrField("count", "long");

}
