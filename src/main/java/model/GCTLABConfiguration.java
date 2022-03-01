
package model;

import model.type.booleanJfrType;
import model.type.longJfrType;

public class GCTLABConfiguration {

    public final static String EVENT = "jdk.GCTLABConfiguration";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static booleanJfrType USES_T_L_A_BS = new booleanJfrType("usesTLABs", EVENT);
    public final static longJfrType MIN_T_L_A_B_SIZE = new longJfrType("minTLABSize", EVENT);
    public final static longJfrType TLAB_REFILL_WASTE_LIMIT = new longJfrType("tlabRefillWasteLimit", EVENT);

}
