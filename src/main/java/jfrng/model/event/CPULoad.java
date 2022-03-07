
package jfrng.model.event;

import jfrng.model.type.floatJfrType;
import jfrng.model.type.longJfrType;

public class CPULoad {

    public final static String EVENT = "jdk.CPULoad";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static floatJfrType JVM_USER = new floatJfrType("jvmUser", EVENT);
    public final static floatJfrType JVM_SYSTEM = new floatJfrType("jvmSystem", EVENT);
    public final static floatJfrType MACHINE_TOTAL = new floatJfrType("machineTotal", EVENT);

}
