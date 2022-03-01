
package model;

import model.type.ClassJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class PromoteObjectInNewPLAB {

    public final static String EVENT = "jdk.PromoteObjectInNewPLAB";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static ClassJfrType OBJECT_CLASS = new ClassJfrType("objectClass", EVENT);
    public final static longJfrType OBJECT_SIZE = new longJfrType("objectSize", EVENT);
    public final static intJfrType TENURING_AGE = new intJfrType("tenuringAge", EVENT);
    public final static booleanJfrType TENURED = new booleanJfrType("tenured", EVENT);
    public final static longJfrType PLAB_SIZE = new longJfrType("plabSize", EVENT);

}
