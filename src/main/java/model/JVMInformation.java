
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class JVMInformation {

    public final static String EVENT = "jdk.JVMInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType JVM_NAME = new StringJfrType("jvmName", EVENT);
    public final static StringJfrType JVM_VERSION = new StringJfrType("jvmVersion", EVENT);
    public final static StringJfrType JVM_ARGUMENTS = new StringJfrType("jvmArguments", EVENT);
    public final static StringJfrType JVM_FLAGS = new StringJfrType("jvmFlags", EVENT);
    public final static StringJfrType JAVA_ARGUMENTS = new StringJfrType("javaArguments", EVENT);
    public final static longJfrType JVM_START_TIME = new longJfrType("jvmStartTime", EVENT);
    public final static longJfrType PID = new longJfrType("pid", EVENT);

}
