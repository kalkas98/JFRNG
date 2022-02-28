
package model;

import model.type.StringJfrType;
import model.type.doubleJfrType;
import model.type.longJfrType;

public class DoubleFlag {

    public final static String eventName = "jdk.DoubleFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static doubleJfrType VALUE = new doubleJfrType("value", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
