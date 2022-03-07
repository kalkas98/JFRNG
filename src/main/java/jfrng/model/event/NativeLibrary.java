
package jfrng.model.event;

import jfrng.model.type.StringJfrType;
import jfrng.model.type.longJfrType;

public class NativeLibrary {

    public final static String EVENT = "jdk.NativeLibrary";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static longJfrType BASE_ADDRESS = new longJfrType("baseAddress", EVENT);
    public final static longJfrType TOP_ADDRESS = new longJfrType("topAddress", EVENT);

}
