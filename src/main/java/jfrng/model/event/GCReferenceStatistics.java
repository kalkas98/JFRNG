
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class GCReferenceStatistics {

    public final static String EVENT = "jdk.GCReferenceStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType TYPE = new StringJfrType("type", EVENT);
    public final static longJfrType COUNT = new longJfrType("count", EVENT);

}
