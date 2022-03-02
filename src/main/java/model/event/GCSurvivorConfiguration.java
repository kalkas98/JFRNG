
package model.event;

import model.type.byteJfrType;
import model.type.longJfrType;

public class GCSurvivorConfiguration {

    public final static String EVENT = "jdk.GCSurvivorConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static byteJfrType MAX_TENURING_THRESHOLD = new byteJfrType("maxTenuringThreshold", EVENT);
    public final static byteJfrType INITIAL_TENURING_THRESHOLD = new byteJfrType("initialTenuringThreshold", EVENT);

}
