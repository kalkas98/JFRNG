
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class InitialEnvironmentVariable {

    public final static String eventName = "jdk.InitialEnvironmentVariable";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType KEY = new StringJfrType("key", eventName);
    public final static StringJfrType VALUE = new StringJfrType("value", eventName);

}
