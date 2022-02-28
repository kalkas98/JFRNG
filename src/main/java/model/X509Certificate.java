
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class X509Certificate {

    public final static String eventName = "jdk.X509Certificate";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType ALGORITHM = new StringJfrType("algorithm", eventName);
    public final static StringJfrType SERIAL_NUMBER = new StringJfrType("serialNumber", eventName);
    public final static StringJfrType SUBJECT = new StringJfrType("subject", eventName);
    public final static StringJfrType ISSUER = new StringJfrType("issuer", eventName);
    public final static StringJfrType KEY_TYPE = new StringJfrType("keyType", eventName);
    public final static intJfrType KEY_LENGTH = new intJfrType("keyLength", eventName);
    public final static longJfrType CERTIFICATE_ID = new longJfrType("certificateId", eventName);
    public final static longJfrType VALID_FROM = new longJfrType("validFrom", eventName);
    public final static longJfrType VALID_UNTIL = new longJfrType("validUntil", eventName);

}
