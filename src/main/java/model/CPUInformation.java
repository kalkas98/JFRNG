
package model;


public class CPUInformation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField CPU = new JfrField("cpu", "String");
    public final static JfrField DESCRIPTION = new JfrField("description", "String");
    public final static JfrField SOCKETS = new JfrField("sockets", "int");
    public final static JfrField CORES = new JfrField("cores", "int");
    public final static JfrField HW_THREADS = new JfrField("hwThreads", "int");

}
