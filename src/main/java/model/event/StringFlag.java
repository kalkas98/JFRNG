
package model.event;

import model.type.StringJfrType;
import model.type.longJfrType;

public class StringFlag {

    public final static String EVENT = "jdk.StringFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static StringJfrType VALUE = new StringJfrType("value", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
