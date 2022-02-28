
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class MetaspaceGCThreshold {

    public final static String eventName = "jdk.MetaspaceGCThreshold";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType OLD_VALUE = new longJfrType("oldValue", eventName);
    public final static longJfrType NEW_VALUE = new longJfrType("newValue", eventName);
    public final static StringJfrType UPDATER = new StringJfrType("updater", eventName);

}
