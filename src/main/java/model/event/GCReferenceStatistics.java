
package model.event;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class GCReferenceStatistics {

    public final static String EVENT = "jdk.GCReferenceStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType TYPE = new StringJfrType("type", EVENT);
    public final static longJfrType COUNT = new longJfrType("count", EVENT);

}
