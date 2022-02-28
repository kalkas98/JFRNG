
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class LongFlagChanged {

    public final static String eventName = "jdk.LongFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static longJfrType OLD_VALUE = new longJfrType("oldValue", eventName);
    public final static longJfrType NEW_VALUE = new longJfrType("newValue", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
