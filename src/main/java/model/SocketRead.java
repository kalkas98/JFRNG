
package model;


public class SocketRead {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField HOST = new JfrField("host", "String");
    public final static JfrField ADDRESS = new JfrField("address", "String");
    public final static JfrField PORT = new JfrField("port", "int");
    public final static JfrField TIMEOUT = new JfrField("timeout", "long");
    public final static JfrField BYTES_READ = new JfrField("bytesRead", "long");
    public final static JfrField END_OF_STREAM = new JfrField("endOfStream", "boolean");

}
