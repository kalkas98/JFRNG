
package model;


public class X509Certificate {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField ALGORITHM = new JfrField("algorithm", "String");
    public final static JfrField SERIAL_NUMBER = new JfrField("serialNumber", "String");
    public final static JfrField SUBJECT = new JfrField("subject", "String");
    public final static JfrField ISSUER = new JfrField("issuer", "String");
    public final static JfrField KEY_TYPE = new JfrField("keyType", "String");
    public final static JfrField KEY_LENGTH = new JfrField("keyLength", "int");
    public final static JfrField CERTIFICATE_ID = new JfrField("certificateId", "long");
    public final static JfrField VALID_FROM = new JfrField("validFrom", "long");
    public final static JfrField VALID_UNTIL = new JfrField("validUntil", "long");

}
