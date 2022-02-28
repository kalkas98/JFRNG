
package model;

import model.type.StringJfrType;
import model.type.doubleJfrType;
import model.type.longJfrType;

public class DoubleFlagChanged {

    public final static String eventName = "jdk.DoubleFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static doubleJfrType OLD_VALUE = new doubleJfrType("oldValue", eventName);
    public final static doubleJfrType NEW_VALUE = new doubleJfrType("newValue", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
