
package model;


public class CPULoad {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField JVM_USER = new JfrField("jvmUser", "float");
    public final static JfrField JVM_SYSTEM = new JfrField("jvmSystem", "float");
    public final static JfrField MACHINE_TOTAL = new JfrField("machineTotal", "float");

}
