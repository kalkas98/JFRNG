
package model;


public class CompilerInlining {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField COMPILE_ID = new JfrField("compileId", "int");
    public final static JfrField CALLER = new JfrField("caller", "Method");
    public final static JfrField CALLEE = new JfrField("callee", "CalleeMethod");
    public final static JfrField SUCCEEDED = new JfrField("succeeded", "boolean");
    public final static JfrField MESSAGE = new JfrField("message", "String");
    public final static JfrField BCI = new JfrField("bci", "int");

}
