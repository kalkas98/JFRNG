
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ActiveRecording {

    public final static String eventName = "jdk.ActiveRecording";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static longJfrType ID = new longJfrType("id", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static StringJfrType DESTINATION = new StringJfrType("destination", eventName);
    public final static longJfrType MAX_AGE = new longJfrType("maxAge", eventName);
    public final static longJfrType FLUSH_INTERVAL = new longJfrType("flushInterval", eventName);
    public final static longJfrType MAX_SIZE = new longJfrType("maxSize", eventName);
    public final static longJfrType RECORDING_START = new longJfrType("recordingStart", eventName);
    public final static longJfrType RECORDING_DURATION = new longJfrType("recordingDuration", eventName);

}
