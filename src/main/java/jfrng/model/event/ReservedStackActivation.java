
package jfrng.model.event;

import jfrng.model.type.MethodJfrType;
import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ReservedStackActivation {

    public final static String EVENT = "jdk.ReservedStackActivation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static MethodJfrType METHOD = new MethodJfrType("method", EVENT);

}
