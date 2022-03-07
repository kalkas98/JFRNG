
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.longJfrType;

public class SystemProcess {

    public final static String EVENT = "jdk.SystemProcess";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType PID = new StringJfrType("pid", EVENT);
    public final static StringJfrType COMMAND_LINE = new StringJfrType("commandLine", EVENT);

}
