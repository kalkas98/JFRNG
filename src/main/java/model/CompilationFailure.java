
package model;


public class CompilationFailure {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField FAILURE_MESSAGE = new JfrField("failureMessage", "String");
    public final static JfrField COMPILE_ID = new JfrField("compileId", "int");

}
