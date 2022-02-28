
package model;


public class ActiveSetting {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField EVENT_THREAD = new JfrField("eventThread", "Thread");
    public final static JfrField STACK_TRACE = new JfrField("stackTrace", "StackTrace");
    public final static JfrField ID = new JfrField("id", "long");
    public final static JfrField NAME = new JfrField("name", "String");
    public final static JfrField VALUE = new JfrField("value", "String");

}
