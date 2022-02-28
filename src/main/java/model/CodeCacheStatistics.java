
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CodeCacheStatistics {

    public final static String eventName = "jdk.CodeCacheStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType CODE_BLOB_TYPE = new StringJfrType("codeBlobType", eventName);
    public final static longJfrType START_ADDRESS = new longJfrType("startAddress", eventName);
    public final static longJfrType RESERVED_TOP_ADDRESS = new longJfrType("reservedTopAddress", eventName);
    public final static intJfrType ENTRY_COUNT = new intJfrType("entryCount", eventName);
    public final static intJfrType METHOD_COUNT = new intJfrType("methodCount", eventName);
    public final static intJfrType ADAPTOR_COUNT = new intJfrType("adaptorCount", eventName);
    public final static longJfrType UNALLOCATED_CAPACITY = new longJfrType("unallocatedCapacity", eventName);
    public final static intJfrType FULL_COUNT = new intJfrType("fullCount", eventName);

}
