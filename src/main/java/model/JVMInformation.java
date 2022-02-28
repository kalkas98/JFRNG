
package model;


public class JVMInformation {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField JVM_NAME = new JfrField("jvmName", "String");
    public final static JfrField JVM_VERSION = new JfrField("jvmVersion", "String");
    public final static JfrField JVM_ARGUMENTS = new JfrField("jvmArguments", "String");
    public final static JfrField JVM_FLAGS = new JfrField("jvmFlags", "String");
    public final static JfrField JAVA_ARGUMENTS = new JfrField("javaArguments", "String");
    public final static JfrField JVM_START_TIME = new JfrField("jvmStartTime", "long");
    public final static JfrField PID = new JfrField("pid", "long");

}
