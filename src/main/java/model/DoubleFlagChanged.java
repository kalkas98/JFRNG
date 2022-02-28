
package model;


public class DoubleFlagChanged {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField NAME = new JfrField("name", "String");
    public final static JfrField OLD_VALUE = new JfrField("oldValue", "double");
    public final static JfrField NEW_VALUE = new JfrField("newValue", "double");
    public final static JfrField ORIGIN = new JfrField("origin", "String");

}
