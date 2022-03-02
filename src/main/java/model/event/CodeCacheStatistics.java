
package model.event;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CodeCacheStatistics {

    public final static String EVENT = "jdk.CodeCacheStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType CODE_BLOB_TYPE = new StringJfrType("codeBlobType", EVENT);
    public final static longJfrType START_ADDRESS = new longJfrType("startAddress", EVENT);
    public final static longJfrType RESERVED_TOP_ADDRESS = new longJfrType("reservedTopAddress", EVENT);
    public final static intJfrType ENTRY_COUNT = new intJfrType("entryCount", EVENT);
    public final static intJfrType METHOD_COUNT = new intJfrType("methodCount", EVENT);
    public final static intJfrType ADAPTOR_COUNT = new intJfrType("adaptorCount", EVENT);
    public final static longJfrType UNALLOCATED_CAPACITY = new longJfrType("unallocatedCapacity", EVENT);
    public final static intJfrType FULL_COUNT = new intJfrType("fullCount", EVENT);

}
