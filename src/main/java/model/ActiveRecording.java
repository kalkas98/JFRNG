
package model;


public class ActiveRecording {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField ID = new JfrField("id", "long");
    public final static JfrField NAME = new JfrField("name", "String");
    public final static JfrField DESTINATION = new JfrField("destination", "String");
    public final static JfrField MAX_AGE = new JfrField("maxAge", "long");
    public final static JfrField FLUSH_INTERVAL = new JfrField("flushInterval", "long");
    public final static JfrField MAX_SIZE = new JfrField("maxSize", "long");
    public final static JfrField RECORDING_START = new JfrField("recordingStart", "long");
    public final static JfrField RECORDING_DURATION = new JfrField("recordingDuration", "long");

}
