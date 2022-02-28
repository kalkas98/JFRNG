
package model;


public class TLSHandshake {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField PEER_HOST = new JfrField("peerHost", "String");
    public final static JfrField PEER_PORT = new JfrField("peerPort", "int");
    public final static JfrField PROTOCOL_VERSION = new JfrField("protocolVersion", "String");
    public final static JfrField CIPHER_SUITE = new JfrField("cipherSuite", "String");
    public final static JfrField CERTIFICATE_ID = new JfrField("certificateId", "long");

}
