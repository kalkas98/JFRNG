
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class LongFlag {

    public final static String EVENT = "jdk.LongFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static longJfrType VALUE = new longJfrType("value", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
