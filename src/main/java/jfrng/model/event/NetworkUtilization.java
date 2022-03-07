
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.longJfrType;

public class NetworkUtilization {

    public final static String EVENT = "jdk.NetworkUtilization";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NETWORK_INTERFACE = new StringJfrType("networkInterface", EVENT);
    public final static longJfrType READ_RATE = new longJfrType("readRate", EVENT);
    public final static longJfrType WRITE_RATE = new longJfrType("writeRate", EVENT);

}
