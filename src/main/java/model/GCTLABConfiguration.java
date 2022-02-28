
package model;


public class GCTLABConfiguration {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField USES_T_L_A_BS = new JfrField("usesTLABs", "boolean");
    public final static JfrField MIN_T_L_A_B_SIZE = new JfrField("minTLABSize", "long");
    public final static JfrField TLAB_REFILL_WASTE_LIMIT = new JfrField("tlabRefillWasteLimit", "long");

}
