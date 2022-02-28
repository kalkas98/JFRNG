
package model;


public class ThreadAllocationStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField ALLOCATED = new JfrField("allocated", "long");
    public final static JfrField THREAD = new JfrField("thread", "Thread");

}
