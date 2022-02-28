
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class JVMInformation {

    public final static String eventName = "jdk.JVMInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType JVM_NAME = new StringJfrType("jvmName", eventName);
    public final static StringJfrType JVM_VERSION = new StringJfrType("jvmVersion", eventName);
    public final static StringJfrType JVM_ARGUMENTS = new StringJfrType("jvmArguments", eventName);
    public final static StringJfrType JVM_FLAGS = new StringJfrType("jvmFlags", eventName);
    public final static StringJfrType JAVA_ARGUMENTS = new StringJfrType("javaArguments", eventName);
    public final static longJfrType JVM_START_TIME = new longJfrType("jvmStartTime", eventName);
    public final static longJfrType PID = new longJfrType("pid", eventName);

}
