
package model;


public class ThreadCPULoad {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField USER = new JfrField("user", "float");
    public final static JfrField SYSTEM = new JfrField("system", "float");

}
