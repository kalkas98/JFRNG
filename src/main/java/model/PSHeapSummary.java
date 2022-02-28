
package model;

import model.type.ObjectSpaceJfrType;
import model.type.StringJfrType;
import model.type.VirtualSpaceJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class PSHeapSummary {

    public final static String eventName = "jdk.PSHeapSummary";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static StringJfrType WHEN = new StringJfrType("when", eventName);
    public final static VirtualSpaceJfrType OLD_SPACE = new VirtualSpaceJfrType("oldSpace", eventName);
    public final static ObjectSpaceJfrType OLD_OBJECT_SPACE = new ObjectSpaceJfrType("oldObjectSpace", eventName);
    public final static VirtualSpaceJfrType YOUNG_SPACE = new VirtualSpaceJfrType("youngSpace", eventName);
    public final static ObjectSpaceJfrType EDEN_SPACE = new ObjectSpaceJfrType("edenSpace", eventName);
    public final static ObjectSpaceJfrType FROM_SPACE = new ObjectSpaceJfrType("fromSpace", eventName);
    public final static ObjectSpaceJfrType TO_SPACE = new ObjectSpaceJfrType("toSpace", eventName);

}
