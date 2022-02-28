
package model;


public class MetaspaceAllocationFailure {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField CLASS_LOADER = new JfrField("classLoader", "ClassLoader");
    public final static JfrField HIDDEN_CLASS_LOADER = new JfrField("hiddenClassLoader", "boolean");
    public final static JfrField SIZE = new JfrField("size", "long");
    public final static JfrField METADATA_TYPE = new JfrField("metadataType", "String");
    public final static JfrField METASPACE_OBJECT_TYPE = new JfrField("metaspaceObjectType", "String");

}
