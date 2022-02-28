
package model;

import model.type.ModuleJfrType;
import model.type.PackageJfrType;
import model.type.longJfrType;

public class ModuleExport {

    public final static String eventName = "jdk.ModuleExport";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static PackageJfrType EXPORTED_PACKAGE = new PackageJfrType("exportedPackage", eventName);
    public final static ModuleJfrType TARGET_MODULE = new ModuleJfrType("targetModule", eventName);

}
