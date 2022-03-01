
package model;

import model.type.longJfrType;

public class ClassLoadingStatistics {

    public final static String EVENT = "jdk.ClassLoadingStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static longJfrType LOADED_CLASS_COUNT = new longJfrType("loadedClassCount", EVENT);
    public final static longJfrType UNLOADED_CLASS_COUNT = new longJfrType("unloadedClassCount", EVENT);

}
