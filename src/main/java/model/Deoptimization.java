
package model;


public class Deoptimization {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField COMPILE_ID = new JfrField("compileId", "int");
    public final static JfrField COMPILER = new JfrField("compiler", "String");
    public final static JfrField METHOD = new JfrField("method", "Method");
    public final static JfrField LINE_NUMBER = new JfrField("lineNumber", "int");
    public final static JfrField BCI = new JfrField("bci", "int");
    public final static JfrField INSTRUCTION = new JfrField("instruction", "String");
    public final static JfrField REASON = new JfrField("reason", "String");
    public final static JfrField ACTION = new JfrField("action", "String");

}
