
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class DumpReason {

    public final static String eventName = "jdk.DumpReason";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType REASON = new StringJfrType("reason", eventName);
    public final static intJfrType RECORDING_ID = new intJfrType("recordingId", eventName);

}
