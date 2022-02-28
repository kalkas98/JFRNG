
package model;

import model.type.ClassJfrType;
import model.type.StackTraceJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ObjectAllocationOutsideTLAB {

    public final static String eventName = "jdk.ObjectAllocationOutsideTLAB";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static StackTraceJfrType STACK_TRACE = new StackTraceJfrType("stackTrace", eventName);
    public final static ClassJfrType OBJECT_CLASS = new ClassJfrType("objectClass", eventName);
    public final static longJfrType ALLOCATION_SIZE = new longJfrType("allocationSize", eventName);

}
