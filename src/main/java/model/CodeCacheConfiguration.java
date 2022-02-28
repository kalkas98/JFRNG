
package model;

import model.type.longJfrType;

public class CodeCacheConfiguration {

    public final static String eventName = "jdk.CodeCacheConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType INITIAL_SIZE = new longJfrType("initialSize", eventName);
    public final static longJfrType RESERVED_SIZE = new longJfrType("reservedSize", eventName);
    public final static longJfrType NON_N_METHOD_SIZE = new longJfrType("nonNMethodSize", eventName);
    public final static longJfrType PROFILED_SIZE = new longJfrType("profiledSize", eventName);
    public final static longJfrType NON_PROFILED_SIZE = new longJfrType("nonProfiledSize", eventName);
    public final static longJfrType EXPANSION_SIZE = new longJfrType("expansionSize", eventName);
    public final static longJfrType MIN_BLOCK_LENGTH = new longJfrType("minBlockLength", eventName);
    public final static longJfrType START_ADDRESS = new longJfrType("startAddress", eventName);
    public final static longJfrType RESERVED_TOP_ADDRESS = new longJfrType("reservedTopAddress", eventName);

}
