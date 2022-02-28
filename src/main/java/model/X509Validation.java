
package model;

import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class X509Validation {

    public final static String eventName = "jdk.X509Validation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType CERTIFICATE_ID = new longJfrType("certificateId", eventName);
    public final static intJfrType CERTIFICATE_POSITION = new intJfrType("certificatePosition", eventName);
    public final static longJfrType VALIDATION_COUNTER = new longJfrType("validationCounter", eventName);

}
