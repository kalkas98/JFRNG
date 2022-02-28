
package model;

import model.type.floatJfrType;
import model.type.longJfrType;

public class CPULoad {

    public final static String eventName = "jdk.CPULoad";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static floatJfrType JVM_USER = new floatJfrType("jvmUser", eventName);
    public final static floatJfrType JVM_SYSTEM = new floatJfrType("jvmSystem", eventName);
    public final static floatJfrType MACHINE_TOTAL = new floatJfrType("machineTotal", eventName);

}
