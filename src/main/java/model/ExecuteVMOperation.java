
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class ExecuteVMOperation {

    public final static String eventName = "jdk.ExecuteVMOperation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StringJfrType OPERATION = new StringJfrType("operation", eventName);
    public final static booleanJfrType SAFEPOINT = new booleanJfrType("safepoint", eventName);
    public final static booleanJfrType BLOCKING = new booleanJfrType("blocking", eventName);
    public final static ThreadJfrType CALLER = new ThreadJfrType("caller", eventName);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", eventName);

}
