
package model;

import model.type.StringJfrType;
import model.type.doubleJfrType;
import model.type.longJfrType;

public class DoubleFlag {

    public final static String EVENT = "jdk.DoubleFlag";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType NAME = new StringJfrType("name", EVENT);
    public final static doubleJfrType VALUE = new doubleJfrType("value", EVENT);
    public final static StringJfrType ORIGIN = new StringJfrType("origin", EVENT);

}
