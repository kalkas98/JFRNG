
package model;

import model.type.ClassJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class PromoteObjectInNewPLAB {

    public final static String eventName = "jdk.PromoteObjectInNewPLAB";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static ClassJfrType OBJECT_CLASS = new ClassJfrType("objectClass", eventName);
    public final static longJfrType OBJECT_SIZE = new longJfrType("objectSize", eventName);
    public final static intJfrType TENURING_AGE = new intJfrType("tenuringAge", eventName);
    public final static booleanJfrType TENURED = new booleanJfrType("tenured", eventName);
    public final static longJfrType PLAB_SIZE = new longJfrType("plabSize", eventName);

}
