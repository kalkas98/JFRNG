
package model;

import model.type.ClassLoaderJfrType;
import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class MetaspaceAllocationFailure {

    public final static String EVENT = "jdk.MetaspaceAllocationFailure";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassLoaderJfrType CLASS_LOADER = new ClassLoaderJfrType("classLoader", EVENT);
    public final static booleanJfrType HIDDEN_CLASS_LOADER = new booleanJfrType("hiddenClassLoader", EVENT);
    public final static longJfrType SIZE = new longJfrType("size", EVENT);
    public final static StringJfrType METADATA_TYPE = new StringJfrType("metadataType", EVENT);
    public final static StringJfrType METASPACE_OBJECT_TYPE = new StringJfrType("metaspaceObjectType", EVENT);

}
