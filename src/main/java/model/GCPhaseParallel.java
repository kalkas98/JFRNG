
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCPhaseParallel {

    public final static String eventName = "jdk.GCPhaseParallel";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static intJfrType GC_WORKER_ID = new intJfrType("gcWorkerId", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);

}
