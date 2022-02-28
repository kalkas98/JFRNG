
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ThreadStart {

    public final static String eventName = "jdk.ThreadStart";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", eventName);
    public final static ThreadJfrType PARENT_THREAD = new ThreadJfrType("parentThread", eventName);

}
