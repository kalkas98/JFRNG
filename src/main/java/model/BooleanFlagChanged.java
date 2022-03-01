
package model;

import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class BooleanFlagChanged {

    public final static String EVENT = "jdk.BooleanFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static booleanJfrType OLD_VALUE = new booleanJfrType("oldValue", EVENT);
    public final static booleanJfrType NEW_VALUE = new booleanJfrType("newValue", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
