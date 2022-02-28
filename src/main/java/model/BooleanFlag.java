
package model;

import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class BooleanFlag {

    public final static String eventName = "jdk.BooleanFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static booleanJfrType VALUE = new booleanJfrType("value", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
