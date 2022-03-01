
package model;

import model.type.longJfrType;

public class Flush {

    public final static String EVENT = "jdk.Flush";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static longJfrType FLUSH_ID = new longJfrType("flushId", EVENT);
    public final static longJfrType ELEMENTS = new longJfrType("elements", EVENT);
    public final static longJfrType SIZE = new longJfrType("size", EVENT);

}
