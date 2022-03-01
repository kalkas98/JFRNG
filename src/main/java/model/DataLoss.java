
package model;

import model.type.longJfrType;

public class DataLoss {

    public final static String EVENT = "jdk.DataLoss";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType AMOUNT = new longJfrType("amount", EVENT);
    public final static longJfrType TOTAL = new longJfrType("total", EVENT);

}
