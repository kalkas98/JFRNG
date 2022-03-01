
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ShenandoahHeapRegionInformation {

    public final static String EVENT = "jdk.ShenandoahHeapRegionInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType INDEX = new intJfrType("index", EVENT);
    public final static StringJfrType STATE = new StringJfrType("state", EVENT);
    public final static longJfrType START = new longJfrType("start", EVENT);
    public final static longJfrType USED = new longJfrType("used", EVENT);

}
