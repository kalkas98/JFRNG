
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCReferenceStatistics {

    public final static String eventName = "jdk.GCReferenceStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static StringJfrType TYPE = new StringJfrType("type", eventName);
    public final static longJfrType COUNT = new longJfrType("count", eventName);

}
