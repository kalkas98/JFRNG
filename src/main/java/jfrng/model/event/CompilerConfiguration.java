
package jfrng.model.event;

import jfrng.model.type.booleanJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class CompilerConfiguration {

    public final static String EVENT = "jdk.CompilerConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType THREAD_COUNT = new intJfrType("threadCount", EVENT);
    public final static booleanJfrType TIERED_COMPILATION = new booleanJfrType("tieredCompilation", EVENT);

}
