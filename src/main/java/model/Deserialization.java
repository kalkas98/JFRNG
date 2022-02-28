
package model;


public class Deserialization {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField FILTER_CONFIGURED = new JfrField("filterConfigured", "boolean");
    public final static JfrField FILTER_STATUS = new JfrField("filterStatus", "String");
    public final static JfrField TYPE = new JfrField("type", "Class");
    public final static JfrField ARRAY_LENGTH = new JfrField("arrayLength", "int");
    public final static JfrField OBJECT_REFERENCES = new JfrField("objectReferences", "long");
    public final static JfrField DEPTH = new JfrField("depth", "long");
    public final static JfrField BYTES_READ = new JfrField("bytesRead", "long");
    public final static JfrField EXCEPTION_TYPE = new JfrField("exceptionType", "Class");
    public final static JfrField EXCEPTION_MESSAGE = new JfrField("exceptionMessage", "String");

}
