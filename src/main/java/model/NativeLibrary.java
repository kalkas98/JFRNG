
package model;

import model.type.StringJfrType;
import model.type.longJfrType;

public class NativeLibrary {

    public final static String eventName = "jdk.NativeLibrary";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType NAME = new StringJfrType("name", eventName);
    public final static longJfrType BASE_ADDRESS = new longJfrType("baseAddress", eventName);
    public final static longJfrType TOP_ADDRESS = new longJfrType("topAddress", eventName);

}
