
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.longJfrType;

public class OSInformation {

    public final static String EVENT = "jdk.OSInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType OS_VERSION = new StringJfrType("osVersion", EVENT);

}
