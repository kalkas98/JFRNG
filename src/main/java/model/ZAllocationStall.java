
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZAllocationStall {

    public final static String eventName = "jdk.ZAllocationStall";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StringJfrType TYPE = new StringJfrType("type", eventName);
    public final static longJfrType SIZE = new longJfrType("size", eventName);

}
