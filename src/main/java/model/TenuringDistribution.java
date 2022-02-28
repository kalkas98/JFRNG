
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class TenuringDistribution {

    public final static String eventName = "jdk.TenuringDistribution";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static intJfrType AGE = new intJfrType("age", eventName);
    public final static longJfrType SIZE = new longJfrType("size", eventName);

}
