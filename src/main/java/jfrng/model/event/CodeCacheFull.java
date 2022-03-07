
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class CodeCacheFull {

    public final static String EVENT = "jdk.CodeCacheFull";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType CODE_BLOB_TYPE = new StringJfrType("codeBlobType", EVENT);
    public final static longJfrType START_ADDRESS = new longJfrType("startAddress", EVENT);
    public final static longJfrType COMMITED_TOP_ADDRESS = new longJfrType("commitedTopAddress", EVENT);
    public final static longJfrType RESERVED_TOP_ADDRESS = new longJfrType("reservedTopAddress", EVENT);
    public final static intJfrType ENTRY_COUNT = new intJfrType("entryCount", EVENT);
    public final static intJfrType METHOD_COUNT = new intJfrType("methodCount", EVENT);
    public final static intJfrType ADAPTOR_COUNT = new intJfrType("adaptorCount", EVENT);
    public final static longJfrType UNALLOCATED_CAPACITY = new longJfrType("unallocatedCapacity", EVENT);
    public final static intJfrType FULL_COUNT = new intJfrType("fullCount", EVENT);

}
