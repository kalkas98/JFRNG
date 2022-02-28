
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class RedefineClasses {

    public final static String eventName = "jdk.RedefineClasses";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static intJfrType CLASS_COUNT = new intJfrType("classCount", eventName);
    public final static longJfrType REDEFINITION_ID = new longJfrType("redefinitionId", eventName);

}
