
package model;

import model.type.ClassJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ObjectCount {

    public final static String eventName = "jdk.ObjectCount";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static ClassJfrType OBJECT_CLASS = new ClassJfrType("objectClass", eventName);
    public final static longJfrType COUNT = new longJfrType("count", eventName);
    public final static longJfrType TOTAL_SIZE = new longJfrType("totalSize", eventName);

}
