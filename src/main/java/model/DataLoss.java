
package model;

import model.type.longJfrType;

public class DataLoss {

    public final static String eventName = "jdk.DataLoss";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType AMOUNT = new longJfrType("amount", eventName);
    public final static longJfrType TOTAL = new longJfrType("total", eventName);

}
