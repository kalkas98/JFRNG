
package model;


public class ClassDefine {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField DEFINED_CLASS = new JfrField("definedClass", "Class");
    public final static JfrField DEFINING_CLASS_LOADER = new JfrField("definingClassLoader", "ClassLoader");

}
