
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class X509Certificate {

    public final static String EVENT = "jdk.X509Certificate";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType ALGORITHM = new StringJfrType("algorithm", EVENT);
    public final static StringJfrType SERIAL_NUMBER = new StringJfrType("serialNumber", EVENT);
    public final static StringJfrType SUBJECT = new StringJfrType("subject", EVENT);
    public final static StringJfrType ISSUER = new StringJfrType("issuer", EVENT);
    public final static StringJfrType KEY_TYPE = new StringJfrType("keyType", EVENT);
    public final static intJfrType KEY_LENGTH = new intJfrType("keyLength", EVENT);
    public final static longJfrType CERTIFICATE_ID = new longJfrType("certificateId", EVENT);
    public final static longJfrType VALID_FROM = new longJfrType("validFrom", EVENT);
    public final static longJfrType VALID_UNTIL = new longJfrType("validUntil", EVENT);

}
