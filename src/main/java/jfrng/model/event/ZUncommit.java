
package jfrng.model.event;

import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ZUncommit {

    public final static String EVENT = "jdk.ZUncommit";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static longJfrType UNCOMMITTED = new longJfrType("uncommitted", EVENT);

}
