
package model;

import model.type.longJfrType;

public class PhysicalMemory {

    public final static String eventName = "jdk.PhysicalMemory";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType TOTAL_SIZE = new longJfrType("totalSize", eventName);
    public final static longJfrType USED_SIZE = new longJfrType("usedSize", eventName);

}
