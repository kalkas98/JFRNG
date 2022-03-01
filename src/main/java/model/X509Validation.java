
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class X509Validation {

    public final static String EVENT = "jdk.X509Validation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType CERTIFICATE_ID = new longJfrType("certificateId", EVENT);
    public final static intJfrType CERTIFICATE_POSITION = new intJfrType("certificatePosition", EVENT);
    public final static longJfrType VALIDATION_COUNTER = new longJfrType("validationCounter", EVENT);

}
