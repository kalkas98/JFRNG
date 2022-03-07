
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ZAllocationStall {

    public final static String EVENT = "jdk.ZAllocationStall";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType TYPE = new StringJfrType("type", EVENT);
    public final static longJfrType SIZE = new longJfrType("size", EVENT);

}
