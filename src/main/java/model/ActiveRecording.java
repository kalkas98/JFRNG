
package model;

import model.type.StackTraceJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ActiveRecording {

    public final static String EVENT = "jdk.ActiveRecording";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static longJfrType ID = new longJfrType("id", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static StringJfrType DESTINATION = new StringJfrType("destination", EVENT);
    public final static longJfrType MAX_AGE = new longJfrType("maxAge", EVENT);
    public final static longJfrType FLUSH_INTERVAL = new longJfrType("flushInterval", EVENT);
    public final static longJfrType MAX_SIZE = new longJfrType("maxSize", EVENT);
    public final static longJfrType RECORDING_START = new longJfrType("recordingStart", EVENT);
    public final static longJfrType RECORDING_DURATION = new longJfrType("recordingDuration", EVENT);

}
