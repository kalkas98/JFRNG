
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.longJfrType;

public class VirtualizationInformation {

    public final static String EVENT = "jdk.VirtualizationInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);

}
