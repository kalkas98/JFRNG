
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class InitialEnvironmentVariable {

    public final static String EVENT = "jdk.InitialEnvironmentVariable";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType KEY = new StringJfrType("key", EVENT);
    public final static StringJfrType VALUE = new StringJfrType("value", EVENT);

}
