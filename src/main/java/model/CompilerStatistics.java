
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class CompilerStatistics {

    public final static String EVENT = "jdk.CompilerStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType COMPILE_COUNT = new intJfrType("compileCount", EVENT);
    public final static intJfrType BAILOUT_COUNT = new intJfrType("bailoutCount", EVENT);
    public final static intJfrType INVALIDATED_COUNT = new intJfrType("invalidatedCount", EVENT);
    public final static intJfrType OSR_COMPILE_COUNT = new intJfrType("osrCompileCount", EVENT);
    public final static intJfrType STANDARD_COMPILE_COUNT = new intJfrType("standardCompileCount", EVENT);
    public final static longJfrType OSR_BYTES_COMPILED = new longJfrType("osrBytesCompiled", EVENT);
    public final static longJfrType STANDARD_BYTES_COMPILED = new longJfrType("standardBytesCompiled", EVENT);
    public final static longJfrType NMETHODS_SIZE = new longJfrType("nmethodsSize", EVENT);
    public final static longJfrType NMETHOD_CODE_SIZE = new longJfrType("nmethodCodeSize", EVENT);
    public final static longJfrType PEAK_TIME_SPENT = new longJfrType("peakTimeSpent", EVENT);
    public final static longJfrType TOTAL_TIME_SPENT = new longJfrType("totalTimeSpent", EVENT);

}
