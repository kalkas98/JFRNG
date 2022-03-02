
package model.event;

import model.type.ClassJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ClassRedefinition {

    public final static String EVENT = "jdk.ClassRedefinition";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ClassJfrType REDEFINED_CLASS = new ClassJfrType("redefinedClass", EVENT);
    public final static intJfrType CLASS_MODIFICATION_COUNT = new intJfrType("classModificationCount", EVENT);
    public final static longJfrType REDEFINITION_ID = new longJfrType("redefinitionId", EVENT);

}
