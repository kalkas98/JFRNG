
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class UnsignedLongFlagChanged {

    public final static String EVENT = "jdk.UnsignedLongFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static longJfrType OLD_VALUE = new longJfrType("oldValue", EVENT);
    public final static longJfrType NEW_VALUE = new longJfrType("newValue", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
