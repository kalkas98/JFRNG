
package jfrng.model.event;

import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ZUnmap {

    public final static String EVENT = "jdk.ZUnmap";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static longJfrType UNMAPPED = new longJfrType("unmapped", EVENT);

}
