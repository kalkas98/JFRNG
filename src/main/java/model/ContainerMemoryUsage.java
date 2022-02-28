
package model;


public class ContainerMemoryUsage {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField MEMORY_FAIL_COUNT = new JfrField("memoryFailCount", "long");
    public final static JfrField MEMORY_USAGE = new JfrField("memoryUsage", "long");
    public final static JfrField SWAP_MEMORY_USAGE = new JfrField("swapMemoryUsage", "long");

}
