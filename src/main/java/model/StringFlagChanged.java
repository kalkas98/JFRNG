
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class StringFlagChanged {

    public final static String eventName = "jdk.StringFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static StringJfrType OLD_VALUE = new StringJfrType("oldValue", eventName);
    public final static StringJfrType NEW_VALUE = new StringJfrType("newValue", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
