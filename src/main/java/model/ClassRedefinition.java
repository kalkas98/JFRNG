
package model;


public class ClassRedefinition {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField REDEFINED_CLASS = new JfrField("redefinedClass", "Class");
    public final static JfrField CLASS_MODIFICATION_COUNT = new JfrField("classModificationCount", "int");
    public final static JfrField REDEFINITION_ID = new JfrField("redefinitionId", "long");

}
