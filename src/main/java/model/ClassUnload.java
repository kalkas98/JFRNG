
package model;


public class ClassUnload {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField UNLOADED_CLASS = new JfrField("unloadedClass", "Class");
    public final static JfrField DEFINING_CLASS_LOADER = new JfrField("definingClassLoader", "ClassLoader");

}
