
package model;


public class MetaspaceGCThreshold {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField OLD_VALUE = new JfrField("oldValue", "long");
    public final static JfrField NEW_VALUE = new JfrField("newValue", "long");
    public final static JfrField UPDATER = new JfrField("updater", "String");

}
