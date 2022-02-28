
package model;

import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZRelocationSet {

    public final static String eventName = "jdk.ZRelocationSet";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static longJfrType TOTAL = new longJfrType("total", eventName);
    public final static longJfrType EMPTY = new longJfrType("empty", eventName);
    public final static longJfrType RELOCATE = new longJfrType("relocate", eventName);

}
