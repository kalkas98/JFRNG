
package model;

import model.type.MetaspaceSizesJfrType;
import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class MetaspaceSummary {

    public final static String eventName = "jdk.MetaspaceSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static StringJfrType WHEN = new StringJfrType("when", eventName);
    public final static longJfrType GC_THRESHOLD = new longJfrType("gcThreshold", eventName);
    public final static MetaspaceSizesJfrType METASPACE = new MetaspaceSizesJfrType("metaspace", eventName);
    public final static MetaspaceSizesJfrType DATA_SPACE = new MetaspaceSizesJfrType("dataSpace", eventName);
    public final static MetaspaceSizesJfrType CLASS_SPACE = new MetaspaceSizesJfrType("classSpace", eventName);

}
