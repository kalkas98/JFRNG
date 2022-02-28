
package model;

import model.type.ClassJfrType;
import model.type.ClassLoaderJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ClassLoad {

    public final static String eventName = "jdk.ClassLoad";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ClassJfrType LOADED_CLASS = new ClassJfrType("loadedClass", eventName);
    public final static ClassLoaderJfrType DEFINING_CLASS_LOADER = new ClassLoaderJfrType("definingClassLoader", eventName);
    public final static ClassLoaderJfrType INITIATING_CLASS_LOADER = new ClassLoaderJfrType("initiatingClassLoader", eventName);

}
