
package model;


public class GCHeapConfiguration {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField MIN_SIZE = new JfrField("minSize", "long");
    public final static JfrField MAX_SIZE = new JfrField("maxSize", "long");
    public final static JfrField INITIAL_SIZE = new JfrField("initialSize", "long");
    public final static JfrField USES_COMPRESSED_OOPS = new JfrField("usesCompressedOops", "boolean");
    public final static JfrField COMPRESSED_OOPS_MODE = new JfrField("compressedOopsMode", "String");
    public final static JfrField OBJECT_ALIGNMENT = new JfrField("objectAlignment", "long");
    public final static JfrField HEAP_ADDRESS_BITS = new JfrField("heapAddressBits", "byte");

}
