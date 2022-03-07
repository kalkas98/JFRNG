
package jfrng.model.event;

import jfrng.model.type.ClassJfrType;
import jfrng.model.type.ClassLoaderJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ClassUnload {

    public final static String EVENT = "jdk.ClassUnload";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static ClassJfrType UNLOADED_CLASS = new ClassJfrType("unloadedClass", EVENT);
    public final static ClassLoaderJfrType DEFINING_CLASS_LOADER = new ClassLoaderJfrType("definingClassLoader", EVENT);

}
