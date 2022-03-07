
package jfrng.model.event;

import jfrng.model.type.G1EvacuationStatisticsJfrType;
import jfrng.model.type.longJfrType;

public class G1EvacuationOldStatistics {

    public final static String EVENT = "jdk.G1EvacuationOldStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static G1EvacuationStatisticsJfrType STATISTICS = new G1EvacuationStatisticsJfrType("statistics", EVENT);

}
