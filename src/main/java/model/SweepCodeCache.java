
package model;

import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class SweepCodeCache {

    public final static String eventName = "jdk.SweepCodeCache";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static intJfrType SWEEP_ID = new intJfrType("sweepId", eventName);
    public final static intJfrType SWEPT_COUNT = new intJfrType("sweptCount", eventName);
    public final static intJfrType FLUSHED_COUNT = new intJfrType("flushedCount", eventName);
    public final static intJfrType ZOMBIFIED_COUNT = new intJfrType("zombifiedCount", eventName);

}
