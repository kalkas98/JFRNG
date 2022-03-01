
package model;

import model.type.StringJfrType;
import model.type.doubleJfrType;
import model.type.longJfrType;

public class DoubleFlagChanged {

    public final static String EVENT = "jdk.DoubleFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static doubleJfrType OLD_VALUE = new doubleJfrType("oldValue", EVENT);
    public final static doubleJfrType NEW_VALUE = new doubleJfrType("newValue", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
