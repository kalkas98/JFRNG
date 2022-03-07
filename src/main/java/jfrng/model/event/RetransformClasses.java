
package jfrng.model.event;

import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class RetransformClasses {

    public final static String EVENT = "jdk.RetransformClasses";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static intJfrType CLASS_COUNT = new intJfrType("classCount", EVENT);
    public final static longJfrType REDEFINITION_ID = new longJfrType("redefinitionId", EVENT);

}
