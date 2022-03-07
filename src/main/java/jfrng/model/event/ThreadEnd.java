
package jfrng.model.event;

import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ThreadEnd {

    public final static String EVENT = "jdk.ThreadEnd";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", EVENT);

}
