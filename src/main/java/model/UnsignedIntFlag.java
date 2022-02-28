
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class UnsignedIntFlag {

    public final static String eventName = "jdk.UnsignedIntFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static intJfrType VALUE = new intJfrType("value", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
