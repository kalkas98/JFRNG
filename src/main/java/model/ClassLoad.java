
package model;

import model.type.ClassJfrType;
import model.type.ClassLoaderJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ClassLoad {

    public final static String EVENT = "jdk.ClassLoad";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassJfrType LOADED_CLASS = new ClassJfrType("loadedClass", EVENT);
    public final static ClassLoaderJfrType DEFINING_CLASS_LOADER = new ClassLoaderJfrType("definingClassLoader", EVENT);
    public final static ClassLoaderJfrType INITIATING_CLASS_LOADER = new ClassLoaderJfrType("initiatingClassLoader", EVENT);

}
