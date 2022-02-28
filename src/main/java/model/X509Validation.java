
package model;


public class X509Validation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField CERTIFICATE_ID = new JfrField("certificateId", "long");
    public final static JfrField CERTIFICATE_POSITION = new JfrField("certificatePosition", "int");
    public final static JfrField VALIDATION_COUNTER = new JfrField("validationCounter", "long");

}
