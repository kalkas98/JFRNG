
package model;

import model.type.ClassJfrType;
import model.type.ClassLoaderJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ClassDefine {

    public final static String EVENT = "jdk.ClassDefine";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassJfrType DEFINED_CLASS = new ClassJfrType("definedClass", EVENT);
    public final static ClassLoaderJfrType DEFINING_CLASS_LOADER = new ClassLoaderJfrType("definingClassLoader", EVENT);

}
