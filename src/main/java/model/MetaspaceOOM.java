
package model;

import model.type.ClassLoaderJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class MetaspaceOOM {

    public final static String eventName = "jdk.MetaspaceOOM";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ClassLoaderJfrType CLASS_LOADER = new ClassLoaderJfrType("classLoader", eventName);
    public final static booleanJfrType HIDDEN_CLASS_LOADER = new booleanJfrType("hiddenClassLoader", eventName);
    public final static longJfrType SIZE = new longJfrType("size", eventName);
    public final static StringJfrType METADATA_TYPE = new StringJfrType("metadataType", eventName);
    public final static StringJfrType METASPACE_OBJECT_TYPE = new StringJfrType("metaspaceObjectType", eventName);

}
