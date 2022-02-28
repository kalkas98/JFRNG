
package model;

import model.type.byteJfrType;
import model.type.longJfrType;

public class GCSurvivorConfiguration {

    public final static String eventName = "jdk.GCSurvivorConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static byteJfrType MAX_TENURING_THRESHOLD = new byteJfrType("maxTenuringThreshold", eventName);
    public final static byteJfrType INITIAL_TENURING_THRESHOLD = new byteJfrType("initialTenuringThreshold", eventName);

}
