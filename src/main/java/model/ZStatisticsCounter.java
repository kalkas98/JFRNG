
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZStatisticsCounter {

    public final static String eventName = "jdk.ZStatisticsCounter";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StringJfrType ID = new StringJfrType("id", eventName);
    public final static longJfrType INCREMENT = new longJfrType("increment", eventName);
    public final static longJfrType VALUE = new longJfrType("value", eventName);

}
