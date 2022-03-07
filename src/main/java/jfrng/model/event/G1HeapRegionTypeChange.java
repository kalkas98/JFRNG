
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class G1HeapRegionTypeChange {

    public final static String EVENT = "jdk.G1HeapRegionTypeChange";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType INDEX = new intJfrType("index", EVENT);
    public final static StringJfrType FROM = new StringJfrType("from", EVENT);
    public final static StringJfrType TO = new StringJfrType("to", EVENT);
    public final static longJfrType START = new longJfrType("start", EVENT);
    public final static longJfrType USED = new longJfrType("used", EVENT);

}
