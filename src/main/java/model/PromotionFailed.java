
package model;


public class PromotionFailed {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField PROMOTION_FAILED = new JfrField("promotionFailed", "CopyFailed");
    public final static JfrField THREAD = new JfrField("thread", "Thread");

}
