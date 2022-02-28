
package model;

import model.type.ModuleJfrType;
import model.type.longJfrType;

public class ModuleRequire {

    public final static String eventName = "jdk.ModuleRequire";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ModuleJfrType SOURCE = new ModuleJfrType("source", eventName);
    public final static ModuleJfrType REQUIRED_MODULE = new ModuleJfrType("requiredModule", eventName);

}
