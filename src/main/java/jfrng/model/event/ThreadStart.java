
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ThreadStart {

    public final static String EVENT = "jdk.ThreadStart";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", EVENT);
    public final static ThreadJfrType PARENT_THREAD = new ThreadJfrType("parentThread", EVENT);

}
