
package model;

import model.type.ClassJfrType;
import model.type.ClassLoaderJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ClassUnload {

    public final static String EVENT = "jdk.ClassUnload";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static ClassJfrType UNLOADED_CLASS = new ClassJfrType("unloadedClass", EVENT);
    public final static ClassLoaderJfrType DEFINING_CLASS_LOADER = new ClassLoaderJfrType("definingClassLoader", EVENT);

}
