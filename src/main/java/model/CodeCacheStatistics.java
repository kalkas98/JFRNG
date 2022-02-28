
package model;


public class CodeCacheStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField CODE_BLOB_TYPE = new JfrField("codeBlobType", "String");
    public final static JfrField START_ADDRESS = new JfrField("startAddress", "long");
    public final static JfrField RESERVED_TOP_ADDRESS = new JfrField("reservedTopAddress", "long");
    public final static JfrField ENTRY_COUNT = new JfrField("entryCount", "int");
    public final static JfrField METHOD_COUNT = new JfrField("methodCount", "int");
    public final static JfrField ADAPTOR_COUNT = new JfrField("adaptorCount", "int");
    public final static JfrField UNALLOCATED_CAPACITY = new JfrField("unallocatedCapacity", "long");
    public final static JfrField FULL_COUNT = new JfrField("fullCount", "int");

}
