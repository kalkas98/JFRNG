
package model;

import model.type.ClassJfrType;
import model.type.ClassLoaderJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ClassUnload {

    public final static String eventName = "jdk.ClassUnload";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static ClassJfrType UNLOADED_CLASS = new ClassJfrType("unloadedClass", eventName);
    public final static ClassLoaderJfrType DEFINING_CLASS_LOADER = new ClassLoaderJfrType("definingClassLoader", eventName);

}
