
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ZStatisticsCounter {

    public final static String EVENT = "jdk.ZStatisticsCounter";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType ID = new StringJfrType("id", EVENT);
    public final static longJfrType INCREMENT = new longJfrType("increment", EVENT);
    public final static longJfrType VALUE = new longJfrType("value", EVENT);

}
