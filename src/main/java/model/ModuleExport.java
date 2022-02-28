
package model;


public class ModuleExport {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EXPORTED_PACKAGE = new JfrField("exportedPackage", "Package");
    public final static JfrField TARGET_MODULE = new JfrField("targetModule", "Module");

}
