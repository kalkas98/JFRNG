
package model;

import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.byteJfrType;
import model.type.longJfrType;

public class GCHeapConfiguration {

    public final static String eventName = "jdk.GCHeapConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType MIN_SIZE = new longJfrType("minSize", eventName);
    public final static longJfrType MAX_SIZE = new longJfrType("maxSize", eventName);
    public final static longJfrType INITIAL_SIZE = new longJfrType("initialSize", eventName);
    public final static booleanJfrType USES_COMPRESSED_OOPS = new booleanJfrType("usesCompressedOops", eventName);
    public final static StringJfrType COMPRESSED_OOPS_MODE = new StringJfrType("compressedOopsMode", eventName);
    public final static longJfrType OBJECT_ALIGNMENT = new longJfrType("objectAlignment", eventName);
    public final static byteJfrType HEAP_ADDRESS_BITS = new byteJfrType("heapAddressBits", eventName);

}
