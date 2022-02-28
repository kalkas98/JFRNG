
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class TLSHandshake {

    public final static String eventName = "jdk.TLSHandshake";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static StringJfrType PEER_HOST = new StringJfrType("peerHost", eventName);
    public final static intJfrType PEER_PORT = new intJfrType("peerPort", eventName);
    public final static StringJfrType PROTOCOL_VERSION = new StringJfrType("protocolVersion", eventName);
    public final static StringJfrType CIPHER_SUITE = new StringJfrType("cipherSuite", eventName);
    public final static longJfrType CERTIFICATE_ID = new longJfrType("certificateId", eventName);

}
