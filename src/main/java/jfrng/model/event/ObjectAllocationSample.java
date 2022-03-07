
package jfrng.model.event;

import jfrng.model.type.ClassJfrType;
import jfrng.model.type.StackTraceJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.longJfrType;

public class ObjectAllocationSample {

    public final static String EVENT = "jdk.ObjectAllocationSample";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", EVENT);
    public final static ClassJfrType OBJECT_CLASS = new ClassJfrType("objectClass", EVENT);
    public final static longJfrType WEIGHT = new longJfrType("weight", EVENT);

}
