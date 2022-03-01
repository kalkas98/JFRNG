
package model;

import model.type.MetaspaceSizesJfrType;
import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class MetaspaceSummary {

    public final static String EVENT = "jdk.MetaspaceSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType WHEN = new StringJfrType("when", EVENT);
    public final static longJfrType GC_THRESHOLD = new longJfrType("gcThreshold", EVENT);
    public final static MetaspaceSizesJfrType METASPACE = new MetaspaceSizesJfrType("metaspace", EVENT);
    public final static MetaspaceSizesJfrType DATA_SPACE = new MetaspaceSizesJfrType("dataSpace", EVENT);
    public final static MetaspaceSizesJfrType CLASS_SPACE = new MetaspaceSizesJfrType("classSpace", EVENT);

}
