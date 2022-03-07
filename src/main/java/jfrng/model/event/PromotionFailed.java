
package jfrng.model.event;

import jfrng.model.type.CopyFailedJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

public class PromotionFailed {

    public final static String EVENT = "jdk.PromotionFailed";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static intJfrType GC_ID = new intJfrType("gcId", EVENT);
    public final static CopyFailedJfrType PROMOTION_FAILED = new CopyFailedJfrType("promotionFailed", EVENT);
    public final static ThreadJfrType THREAD = new ThreadJfrType("thread", EVENT);

}
