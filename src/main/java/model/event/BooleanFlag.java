
package model.event;

import model.type.StringJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class BooleanFlag {

    public final static String EVENT = "jdk.BooleanFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static booleanJfrType VALUE = new booleanJfrType("value", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
