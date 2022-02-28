
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class InitialSystemProperty {

    public final static String eventName = "jdk.InitialSystemProperty";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType KEY = new StringJfrType("key", eventName);
    public final static StringJfrType VALUE = new StringJfrType("value", eventName);

}
