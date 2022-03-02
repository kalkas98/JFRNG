
package model.event;

import model.type.StringJfrType;
import model.type.longJfrType;

public class ThreadDump {

    public final static String EVENT = "jdk.ThreadDump";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType RESULT = new StringJfrType("result", EVENT);

}
