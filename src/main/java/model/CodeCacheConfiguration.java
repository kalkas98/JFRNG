
package model;


public class CodeCacheConfiguration {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField INITIAL_SIZE = new JfrField("initialSize", "long");
    public final static JfrField RESERVED_SIZE = new JfrField("reservedSize", "long");
    public final static JfrField NON_N_METHOD_SIZE = new JfrField("nonNMethodSize", "long");
    public final static JfrField PROFILED_SIZE = new JfrField("profiledSize", "long");
    public final static JfrField NON_PROFILED_SIZE = new JfrField("nonProfiledSize", "long");
    public final static JfrField EXPANSION_SIZE = new JfrField("expansionSize", "long");
    public final static JfrField MIN_BLOCK_LENGTH = new JfrField("minBlockLength", "long");
    public final static JfrField START_ADDRESS = new JfrField("startAddress", "long");
    public final static JfrField RESERVED_TOP_ADDRESS = new JfrField("reservedTopAddress", "long");

}
