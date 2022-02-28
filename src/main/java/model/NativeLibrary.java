
package model;


public class NativeLibrary {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField NAME = new JfrField("name", "String");
    public final static JfrField BASE_ADDRESS = new JfrField("baseAddress", "long");
    public final static JfrField TOP_ADDRESS = new JfrField("topAddress", "long");

}
