
package model.event;

import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZRelocationSet {

    public final static String EVENT = "jdk.ZRelocationSet";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static longJfrType TOTAL = new longJfrType("total", EVENT);
    public final static longJfrType EMPTY = new longJfrType("empty", EVENT);
    public final static longJfrType RELOCATE = new longJfrType("relocate", EVENT);

}
