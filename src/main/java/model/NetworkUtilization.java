
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class NetworkUtilization {

    public final static String eventName = "jdk.NetworkUtilization";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NETWORK_INTERFACE = new StringJfrType("networkInterface", eventName);
    public final static longJfrType READ_RATE = new longJfrType("readRate", eventName);
    public final static longJfrType WRITE_RATE = new longJfrType("writeRate", eventName);

}
