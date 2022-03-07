
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class UnsignedIntFlagChanged {

    public final static String EVENT = "jdk.UnsignedIntFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static intJfrType OLD_VALUE = new intJfrType("oldValue", EVENT);
    public final static intJfrType NEW_VALUE = new intJfrType("newValue", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
