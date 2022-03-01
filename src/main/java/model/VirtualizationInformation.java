
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class VirtualizationInformation {

    public final static String EVENT = "jdk.VirtualizationInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);

}
