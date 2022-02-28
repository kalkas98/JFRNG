
package model;


public class CompilerPhase {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField PHASE = new JfrField("phase", "String");
    public final static JfrField COMPILE_ID = new JfrField("compileId", "int");
    public final static JfrField PHASE_LEVEL = new JfrField("phaseLevel", "short");

}
