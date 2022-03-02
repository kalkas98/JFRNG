
package model.event;

import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.longJfrType;

public class ZRelocationSetGroup {

    public final static String EVENT = "jdk.ZRelocationSetGroup";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType DURATION = new longJfrType("duration", EVENT);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", EVENT);
    public final static StringJfrType TYPE = new StringJfrType("type", EVENT);
    public final static longJfrType PAGES = new longJfrType("pages", EVENT);
    public final static longJfrType TOTAL = new longJfrType("total", EVENT);
    public final static longJfrType EMPTY = new longJfrType("empty", EVENT);
    public final static longJfrType RELOCATE = new longJfrType("relocate", EVENT);

}
