
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.booleanJfrType;
import jfrng.model.type.byteJfrType;
import jfrng.model.type.longJfrType;

public class GCHeapConfiguration {

    public final static String EVENT = "jdk.GCHeapConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType MIN_SIZE = new longJfrType("minSize", EVENT);
    public final static longJfrType MAX_SIZE = new longJfrType("maxSize", EVENT);
    public final static longJfrType INITIAL_SIZE = new longJfrType("initialSize", EVENT);
    public final static booleanJfrType USES_COMPRESSED_OOPS = new booleanJfrType("usesCompressedOops", EVENT);
    public final static StringJfrType COMPRESSED_OOPS_MODE = new StringJfrType("compressedOopsMode", EVENT);
    public final static longJfrType OBJECT_ALIGNMENT = new longJfrType("objectAlignment", EVENT);
    public final static byteJfrType HEAP_ADDRESS_BITS = new byteJfrType("heapAddressBits", EVENT);

}
