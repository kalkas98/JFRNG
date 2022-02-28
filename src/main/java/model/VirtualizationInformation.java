
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class VirtualizationInformation {

    public final static String eventName = "jdk.VirtualizationInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);

}
