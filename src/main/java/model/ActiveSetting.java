
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ActiveSetting {

    public final static String EVENT = "jdk.ActiveSetting";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType ID = new longJfrType("id", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static StringJfrType VALUE = new StringJfrType("value", EVENT);

}
