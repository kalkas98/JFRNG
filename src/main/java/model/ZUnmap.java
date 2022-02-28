
package model;

import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZUnmap {

    public final static String eventName = "jdk.ZUnmap";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static longJfrType UNMAPPED = new longJfrType("unmapped", eventName);

}
