
package model;


public class MetaspaceSummary {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField WHEN = new JfrField("when", "String");
    public final static JfrField GC_THRESHOLD = new JfrField("gcThreshold", "long");
    public final static JfrField METASPACE = new JfrField("metaspace", "MetaspaceSizes");
    public final static JfrField DATA_SPACE = new JfrField("dataSpace", "MetaspaceSizes");
    public final static JfrField CLASS_SPACE = new JfrField("classSpace", "MetaspaceSizes");

}
