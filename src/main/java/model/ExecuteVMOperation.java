
package model;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.longJfrType;

public class ExecuteVMOperation {

    public final static String EVENT = "jdk.ExecuteVMOperation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType OPERATION = new StringJfrType("operation", EVENT);
    public final static booleanJfrType SAFEPOINT = new booleanJfrType("safepoint", EVENT);
    public final static booleanJfrType BLOCKING = new booleanJfrType("blocking", EVENT);
    public final static ThreadJfrType CALLER = new ThreadJfrType("caller", EVENT);
    public final static longJfrType SAFEPOINT_ID = new longJfrType("safepointId", EVENT);

}
