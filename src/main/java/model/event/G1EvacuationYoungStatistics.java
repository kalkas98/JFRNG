
package model.event;

import model.type.G1EvacuationStatisticsJfrType;
import model.type.longJfrType;

public class G1EvacuationYoungStatistics {

    public final static String EVENT = "jdk.G1EvacuationYoungStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static G1EvacuationStatisticsJfrType STATISTICS = new G1EvacuationStatisticsJfrType("statistics", EVENT);

}
