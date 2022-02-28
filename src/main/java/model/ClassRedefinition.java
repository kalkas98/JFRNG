
package model;

import model.type.ClassJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ClassRedefinition {

    public final static String eventName = "jdk.ClassRedefinition";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ClassJfrType REDEFINED_CLASS = new ClassJfrType("redefinedClass", eventName);
    public final static intJfrType CLASS_MODIFICATION_COUNT = new intJfrType("classModificationCount", eventName);
    public final static longJfrType REDEFINITION_ID = new longJfrType("redefinitionId", eventName);

}
