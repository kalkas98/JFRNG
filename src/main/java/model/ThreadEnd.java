
package model;

import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ThreadEnd {

    public final static String eventName = "jdk.ThreadEnd";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", eventName);

}
