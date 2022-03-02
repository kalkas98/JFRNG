
package model.event;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class IntFlag {

    public final static String EVENT = "jdk.IntFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static intJfrType VALUE = new intJfrType("value", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
