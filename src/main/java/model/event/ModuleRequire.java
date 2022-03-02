
package model.event;

import model.type.ModuleJfrType;
import model.type.longJfrType;

public class ModuleRequire {

    public final static String EVENT = "jdk.ModuleRequire";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ModuleJfrType SOURCE = new ModuleJfrType("source", EVENT);
    public final static ModuleJfrType REQUIRED_MODULE = new ModuleJfrType("requiredModule", EVENT);

}
