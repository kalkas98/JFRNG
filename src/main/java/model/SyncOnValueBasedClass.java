
package model;


public class SyncOnValueBasedClass {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField VALUE_BASED_CLASS = new JfrField("valueBasedClass", "Class");

}
