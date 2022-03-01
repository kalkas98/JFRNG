
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1GarbageCollection {

    public final static String EVENT = "jdk.G1GarbageCollection";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType TYPE = new StringJfrType("type", EVENT);

}
