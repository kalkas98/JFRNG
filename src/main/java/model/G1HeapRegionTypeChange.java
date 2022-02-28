
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class G1HeapRegionTypeChange {

    public final static String eventName = "jdk.G1HeapRegionTypeChange";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType INDEX = new intJfrType("index", eventName);
    public final static StringJfrType FROM = new StringJfrType("from", eventName);
    public final static StringJfrType TO = new StringJfrType("to", eventName);
    public final static longJfrType START = new longJfrType("start", eventName);
    public final static longJfrType USED = new longJfrType("used", eventName);

}
