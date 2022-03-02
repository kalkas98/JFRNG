
package model.event;

import model.type.ClassJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ObjectCount {

    public final static String EVENT = "jdk.ObjectCount";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static ClassJfrType OBJECT_CLASS = new ClassJfrType("objectClass", EVENT);
    public final static longJfrType COUNT = new longJfrType("count", EVENT);
    public final static longJfrType TOTAL_SIZE = new longJfrType("totalSize", EVENT);

}
