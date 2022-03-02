
package model.event;

import model.type.StringJfrType;
import model.type.longJfrType;

public class OSInformation {

    public final static String EVENT = "jdk.OSInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType OS_VERSION = new StringJfrType("osVersion", EVENT);

}
