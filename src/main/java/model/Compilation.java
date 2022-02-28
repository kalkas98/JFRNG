
package model;


public class Compilation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField COMPILE_ID = new JfrField("compileId", "int");
    public final static JfrField COMPILER = new JfrField("compiler", "String");
    public final static JfrField METHOD = new JfrField("method", "Method");
    public final static JfrField COMPILE_LEVEL = new JfrField("compileLevel", "short");
    public final static JfrField SUCCEDED = new JfrField("succeded", "boolean");
    public final static JfrField IS_OSR = new JfrField("isOsr", "boolean");
    public final static JfrField CODE_SIZE = new JfrField("codeSize", "long");
    public final static JfrField INLINED_BYTES = new JfrField("inlinedBytes", "long");

}
