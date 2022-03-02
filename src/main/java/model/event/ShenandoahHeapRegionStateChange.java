
package model.event;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ShenandoahHeapRegionStateChange {

    public final static String EVENT = "jdk.ShenandoahHeapRegionStateChange";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType INDEX = new intJfrType("index", EVENT);
    public final static StringJfrType FROM = new StringJfrType("from", EVENT);
    public final static StringJfrType TO = new StringJfrType("to", EVENT);
    public final static longJfrType START = new longJfrType("start", EVENT);
    public final static longJfrType USED = new longJfrType("used", EVENT);

}
