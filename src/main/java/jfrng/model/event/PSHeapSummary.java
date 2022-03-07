
package jfrng.model.event;

import jfrng.model.type.ObjectSpaceJfrType;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.VirtualSpaceJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class PSHeapSummary {

    public final static String EVENT = "jdk.PSHeapSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static StringJfrType WHEN = new StringJfrType("when", EVENT);
    public final static VirtualSpaceJfrType OLD_SPACE = new VirtualSpaceJfrType("oldSpace", EVENT);
    public final static ObjectSpaceJfrType OLD_OBJECT_SPACE = new ObjectSpaceJfrType("oldObjectSpace", EVENT);
    public final static VirtualSpaceJfrType YOUNG_SPACE = new VirtualSpaceJfrType("youngSpace", EVENT);
    public final static ObjectSpaceJfrType EDEN_SPACE = new ObjectSpaceJfrType("edenSpace", EVENT);
    public final static ObjectSpaceJfrType FROM_SPACE = new ObjectSpaceJfrType("fromSpace", EVENT);
    public final static ObjectSpaceJfrType TO_SPACE = new ObjectSpaceJfrType("toSpace", EVENT);

}
