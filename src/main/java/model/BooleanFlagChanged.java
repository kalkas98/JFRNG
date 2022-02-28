
package model;

import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class BooleanFlagChanged {

    public final static String eventName = "jdk.BooleanFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static booleanJfrType OLD_VALUE = new booleanJfrType("oldValue", eventName);
    public final static booleanJfrType NEW_VALUE = new booleanJfrType("newValue", eventName);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", eventName);

}
