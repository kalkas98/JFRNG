
package model;


public class ObjectCountAfterGC {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField OBJECT_CLASS = new JfrField("objectClass", "Class");
    public final static JfrField COUNT = new JfrField("count", "long");
    public final static JfrField TOTAL_SIZE = new JfrField("totalSize", "long");

}
