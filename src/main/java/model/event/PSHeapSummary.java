
package model.event;

import model.type.ObjectSpaceJfrType;
import model.type.StringJfrType;
import model.type.VirtualSpaceJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

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
