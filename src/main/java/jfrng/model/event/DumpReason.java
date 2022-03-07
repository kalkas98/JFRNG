
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class DumpReason {

    public final static String EVENT = "jdk.DumpReason";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType REASON = new StringJfrType("reason", EVENT);
    public final static intJfrType RECORDING_ID = new intJfrType("recordingId", EVENT);

}
