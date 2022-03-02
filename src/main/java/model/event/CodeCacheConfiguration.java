
package model.event;

import model.type.longJfrType;

public class CodeCacheConfiguration {

    public final static String EVENT = "jdk.CodeCacheConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType INITIAL_SIZE = new longJfrType("initialSize", EVENT);
    public final static longJfrType RESERVED_SIZE = new longJfrType("reservedSize", EVENT);
    public final static longJfrType NON_N_METHOD_SIZE = new longJfrType("nonNMethodSize", EVENT);
    public final static longJfrType PROFILED_SIZE = new longJfrType("profiledSize", EVENT);
    public final static longJfrType NON_PROFILED_SIZE = new longJfrType("nonProfiledSize", EVENT);
    public final static longJfrType EXPANSION_SIZE = new longJfrType("expansionSize", EVENT);
    public final static longJfrType MIN_BLOCK_LENGTH = new longJfrType("minBlockLength", EVENT);
    public final static longJfrType START_ADDRESS = new longJfrType("startAddress", EVENT);
    public final static longJfrType RESERVED_TOP_ADDRESS = new longJfrType("reservedTopAddress", EVENT);

}
