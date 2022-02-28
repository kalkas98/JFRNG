
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class YoungGenerationConfiguration {

    public final static String eventName = "jdk.YoungGenerationConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType MIN_SIZE = new longJfrType("minSize", eventName);
    public final static longJfrType MAX_SIZE = new longJfrType("maxSize", eventName);
    public final static intJfrType NEW_RATIO = new intJfrType("newRatio", eventName);

}
