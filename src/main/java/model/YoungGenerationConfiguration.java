
package model;

import model.type.intJfrType;
import model.type.longJfrType;

public class YoungGenerationConfiguration {

    public final static String EVENT = "jdk.YoungGenerationConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType MIN_SIZE = new longJfrType("minSize", EVENT);
    public final static longJfrType MAX_SIZE = new longJfrType("maxSize", EVENT);
    public final static intJfrType NEW_RATIO = new intJfrType("newRatio", EVENT);

}
