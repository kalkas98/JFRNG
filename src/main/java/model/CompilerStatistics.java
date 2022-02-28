
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class CompilerStatistics {

    public final static String eventName = "jdk.CompilerStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType COMPILE_COUNT = new intJfrType("compileCount", eventName);
    public final static intJfrType BAILOUT_COUNT = new intJfrType("bailoutCount", eventName);
    public final static intJfrType INVALIDATED_COUNT = new intJfrType("invalidatedCount", eventName);
    public final static intJfrType OSR_COMPILE_COUNT = new intJfrType("osrCompileCount", eventName);
    public final static intJfrType STANDARD_COMPILE_COUNT = new intJfrType("standardCompileCount", eventName);
    public final static longJfrType OSR_BYTES_COMPILED = new longJfrType("osrBytesCompiled", eventName);
    public final static longJfrType STANDARD_BYTES_COMPILED = new longJfrType("standardBytesCompiled", eventName);
    public final static longJfrType NMETHODS_SIZE = new longJfrType("nmethodsSize", eventName);
    public final static longJfrType NMETHOD_CODE_SIZE = new longJfrType("nmethodCodeSize", eventName);
    public final static longJfrType PEAK_TIME_SPENT = new longJfrType("peakTimeSpent", eventName);
    public final static longJfrType TOTAL_TIME_SPENT = new longJfrType("totalTimeSpent", eventName);

}
