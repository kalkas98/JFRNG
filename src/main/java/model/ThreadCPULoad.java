
package model;

import model.type.ThreadJfrType;
import model.type.floatJfrType;
import model.type.longJfrType;

public class ThreadCPULoad {

    public final static String EVENT = "jdk.ThreadCPULoad";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static floatJfrType USER = new floatJfrType("user", EVENT);
    public final static floatJfrType SYSTEM = new floatJfrType("system", EVENT);

}
