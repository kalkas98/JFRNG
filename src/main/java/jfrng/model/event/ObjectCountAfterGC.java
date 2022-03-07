
package jfrng.model.event;

import jfrng.model.type.ClassJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class ObjectCountAfterGC {

    public final static String EVENT = "jdk.ObjectCountAfterGC";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static ClassJfrType OBJECT_CLASS = new ClassJfrType("objectClass", EVENT);
    public final static longJfrType COUNT = new longJfrType("count", EVENT);
    public final static longJfrType TOTAL_SIZE = new longJfrType("totalSize", EVENT);

}
