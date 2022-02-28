
package model;


public class CompilerStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField COMPILE_COUNT = new JfrField("compileCount", "int");
    public final static JfrField BAILOUT_COUNT = new JfrField("bailoutCount", "int");
    public final static JfrField INVALIDATED_COUNT = new JfrField("invalidatedCount", "int");
    public final static JfrField OSR_COMPILE_COUNT = new JfrField("osrCompileCount", "int");
    public final static JfrField STANDARD_COMPILE_COUNT = new JfrField("standardCompileCount", "int");
    public final static JfrField OSR_BYTES_COMPILED = new JfrField("osrBytesCompiled", "long");
    public final static JfrField STANDARD_BYTES_COMPILED = new JfrField("standardBytesCompiled", "long");
    public final static JfrField NMETHODS_SIZE = new JfrField("nmethodsSize", "long");
    public final static JfrField NMETHOD_CODE_SIZE = new JfrField("nmethodCodeSize", "long");
    public final static JfrField PEAK_TIME_SPENT = new JfrField("peakTimeSpent", "long");
    public final static JfrField TOTAL_TIME_SPENT = new JfrField("totalTimeSpent", "long");

}
