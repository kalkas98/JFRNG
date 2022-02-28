
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class UnsignedIntFlagChanged {

    public final static String eventName = "jdk.UnsignedIntFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static intJfrType OLD_VALUE = new intJfrType("oldValue", eventName);
    public final static intJfrType NEW_VALUE = new intJfrType("newValue", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
