
package model;

import model.type.ThreadJfrType;
import model.type.floatJfrType;
import model.type.longJfrType;

public class ThreadCPULoad {

    public final static String eventName = "jdk.ThreadCPULoad";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static floatJfrType USER = new floatJfrType("user", eventName);
    public final static floatJfrType SYSTEM = new floatJfrType("system", eventName);

}
