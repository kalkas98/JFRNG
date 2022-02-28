
package model;


public class FileRead {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField PATH = new JfrField("path", "String");
    public final static JfrField BYTES_READ = new JfrField("bytesRead", "long");
    public final static JfrField END_OF_FILE = new JfrField("endOfFile", "boolean");

}
