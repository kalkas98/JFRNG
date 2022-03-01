
package model;

import model.type.ModuleJfrType;
import model.type.PackageJfrType;
import model.type.longJfrType;

public class ModuleExport {

    public final static String EVENT = "jdk.ModuleExport";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static PackageJfrType EXPORTED_PACKAGE = new PackageJfrType("exportedPackage", EVENT);
    public final static ModuleJfrType TARGET_MODULE = new ModuleJfrType("targetModule", EVENT);

}
