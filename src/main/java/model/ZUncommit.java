
package model;

import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZUncommit {

    public final static String eventName = "jdk.ZUncommit";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static longJfrType UNCOMMITTED = new longJfrType("uncommitted", eventName);

}
