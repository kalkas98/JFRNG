
package model;

import model.type.booleanJfrType;
import model.type.longJfrType;

public class GCTLABConfiguration {

    public final static String eventName = "jdk.GCTLABConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static booleanJfrType USES_T_L_A_BS = new booleanJfrType("usesTLABs", eventName);
    public final static longJfrType MIN_T_L_A_B_SIZE = new longJfrType("minTLABSize", eventName);
    public final static longJfrType TLAB_REFILL_WASTE_LIMIT = new longJfrType("tlabRefillWasteLimit", eventName);

}
