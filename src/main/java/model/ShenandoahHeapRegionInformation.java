
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class ShenandoahHeapRegionInformation {

    public final static String eventName = "jdk.ShenandoahHeapRegionInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType INDEX = new intJfrType("index", eventName);
    public final static StringJfrType STATE = new StringJfrType("state", eventName);
    public final static longJfrType START = new longJfrType("start", eventName);
    public final static longJfrType USED = new longJfrType("used", eventName);

}
