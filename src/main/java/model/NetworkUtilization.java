
package model;


public class NetworkUtilization {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField NETWORK_INTERFACE = new JfrField("networkInterface", "String");
    public final static JfrField READ_RATE = new JfrField("readRate", "long");
    public final static JfrField WRITE_RATE = new JfrField("writeRate", "long");

}
