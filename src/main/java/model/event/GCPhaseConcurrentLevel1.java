
package model.event;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCPhaseConcurrentLevel1 {

    public final static String EVENT = "jdk.GCPhaseConcurrentLevel1";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);

}
