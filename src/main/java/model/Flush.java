
package model;

import model.type.longJfrType;

public class Flush {

    public final static String eventName = "jdk.Flush";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static longJfrType FLUSH_ID = new longJfrType("flushId", eventName);
    public final static longJfrType ELEMENTS = new longJfrType("elements", eventName);
    public final static longJfrType SIZE = new longJfrType("size", eventName);

}
