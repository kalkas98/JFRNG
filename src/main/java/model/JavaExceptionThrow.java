
package model;


public class JavaExceptionThrow {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField MESSAGE = new JfrField("message", "String");
    public final static JfrField THROWN_CLASS = new JfrField("thrownClass", "Class");

}
