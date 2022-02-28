
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ActiveSetting {

    public final static String eventName = "jdk.ActiveSetting";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType ID = new longJfrType("id", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static StringJfrType VALUE = new StringJfrType("value", eventName);

}
