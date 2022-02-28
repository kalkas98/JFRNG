
package model;


public class ClassLoad {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField LOADED_CLASS = new JfrField("loadedClass", "Class");
    public final static JfrField DEFINING_CLASS_LOADER = new JfrField("definingClassLoader", "ClassLoader");
    public final static JfrField INITIATING_CLASS_LOADER = new JfrField("initiatingClassLoader", "ClassLoader");

}
