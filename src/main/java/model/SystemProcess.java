
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class SystemProcess {

    public final static String eventName = "jdk.SystemProcess";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType PID = new StringJfrType("pid", eventName);
    public final static StringJfrType COMMAND_LINE = new StringJfrType("commandLine", eventName);

}
