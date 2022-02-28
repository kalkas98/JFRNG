
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class OSInformation {

    public final static String eventName = "jdk.OSInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType OS_VERSION = new StringJfrType("osVersion", eventName);

}
