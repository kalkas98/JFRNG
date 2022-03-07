
package jfrng.model.event;

import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class SweepCodeCache {

    public final static String EVENT = "jdk.SweepCodeCache";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static intJfrType SWEEP_ID = new intJfrType("sweepId", EVENT);
    public final static intJfrType SWEPT_COUNT = new intJfrType("sweptCount", EVENT);
    public final static intJfrType FLUSHED_COUNT = new intJfrType("flushedCount", EVENT);
    public final static intJfrType ZOMBIFIED_COUNT = new intJfrType("zombifiedCount", EVENT);

}
