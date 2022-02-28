
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class LongFlag {

    public final static String eventName = "jdk.LongFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static longJfrType VALUE = new longJfrType("value", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
