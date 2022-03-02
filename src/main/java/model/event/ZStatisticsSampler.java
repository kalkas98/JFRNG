
package model.event;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZStatisticsSampler {

    public final static String EVENT = "jdk.ZStatisticsSampler";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType ID = new StringJfrType("id", EVENT);
    public final static longJfrType VALUE = new longJfrType("value", EVENT);

}
