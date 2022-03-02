
package model.event;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1HeapRegionInformation {

    public final static String EVENT = "jdk.G1HeapRegionInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType INDEX = new intJfrType("index", EVENT);
    public final static StringJfrType TYPE = new StringJfrType("type", EVENT);
    public final static longJfrType START = new longJfrType("start", EVENT);
    public final static longJfrType USED = new longJfrType("used", EVENT);

}
