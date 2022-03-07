
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class TLSHandshake {

    public final static String EVENT = "jdk.TLSHandshake";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static StringJfrType PEER_HOST = new StringJfrType("peerHost", EVENT);
    public final static intJfrType PEER_PORT = new intJfrType("peerPort", EVENT);
    public final static StringJfrType PROTOCOL_VERSION = new StringJfrType("protocolVersion", EVENT);
    public final static StringJfrType CIPHER_SUITE = new StringJfrType("cipherSuite", EVENT);
    public final static longJfrType CERTIFICATE_ID = new longJfrType("certificateId", EVENT);

}
