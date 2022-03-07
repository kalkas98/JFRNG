
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.doubleJfrType;
import jfrng.model.type.longJfrType;

public class DoubleFlag {

    public final static String EVENT = "jdk.DoubleFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static doubleJfrType VALUE = new doubleJfrType("value", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
