
package model.event;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class DumpReason {

    public final static String EVENT = "jdk.DumpReason";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType REASON = new StringJfrType("reason", EVENT);
    public final static intJfrType RECORDING_ID = new intJfrType("recordingId", EVENT);

}
