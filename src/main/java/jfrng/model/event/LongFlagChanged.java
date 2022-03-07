
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.longJfrType;

public class LongFlagChanged {

    public final static String EVENT = "jdk.LongFlagChanged";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static longJfrType OLD_VALUE = new longJfrType("oldValue", EVENT);
    public final static longJfrType NEW_VALUE = new longJfrType("newValue", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
