
package model;

import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CompilerConfiguration {

    public final static String eventName = "jdk.CompilerConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType THREAD_COUNT = new intJfrType("threadCount", eventName);
    public final static booleanJfrType TIERED_COMPILATION = new booleanJfrType("tieredCompilation", eventName);

}
