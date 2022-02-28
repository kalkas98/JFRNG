
package model;

import model.type.CopyFailedJfrType;
import model.type.ThreadJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class PromotionFailed {

    public final static String eventName = "jdk.PromotionFailed";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static intJfrType GC_ID = new intJfrType("gcId", eventName);
    public final static CopyFailedJfrType PROMOTION_FAILED = new CopyFailedJfrType("promotionFailed", eventName);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", eventName);

}
