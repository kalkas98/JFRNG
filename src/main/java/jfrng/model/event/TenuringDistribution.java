
package jfrng.model.event;

import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class TenuringDistribution {

    public final static String EVENT = "jdk.TenuringDistribution";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static intJfrType AGE = new intJfrType("age", EVENT);
    public final static longJfrType SIZE = new longJfrType("size", EVENT);

}
