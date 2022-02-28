
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class ThreadDump {

    public final static String eventName = "jdk.ThreadDump";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType RESULT = new StringJfrType("result", eventName);

}
