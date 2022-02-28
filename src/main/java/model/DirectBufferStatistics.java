
package model;


public class DirectBufferStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField MAX_CAPACITY = new JfrField("maxCapacity", "long");
    public final static JfrField COUNT = new JfrField("count", "long");
    public final static JfrField TOTAL_CAPACITY = new JfrField("totalCapacity", "long");
    public final static JfrField MEMORY_USED = new JfrField("memoryUsed", "long");

}
