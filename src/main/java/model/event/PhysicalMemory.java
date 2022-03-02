
package model.event;

import model.type.longJfrType;

public class PhysicalMemory {

    public final static String EVENT = "jdk.PhysicalMemory";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType TOTAL_SIZE = new longJfrType("totalSize", EVENT);
    public final static longJfrType USED_SIZE = new longJfrType("usedSize", EVENT);

}
