
package model.event;

import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CompilerConfiguration {

    public final static String EVENT = "jdk.CompilerConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType THREAD_COUNT = new intJfrType("threadCount", EVENT);
    public final static booleanJfrType TIERED_COMPILATION = new booleanJfrType("tieredCompilation", EVENT);

}
