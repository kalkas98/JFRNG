
package model;


public class ModuleRequire {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField SOURCE = new JfrField("source", "Module");
    public final static JfrField REQUIRED_MODULE = new JfrField("requiredModule", "Module");

}
