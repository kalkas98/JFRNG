
package model;


public class SystemProcess {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField PID = new JfrField("pid", "String");
    public final static JfrField COMMAND_LINE = new JfrField("commandLine", "String");

}
