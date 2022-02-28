
package model;

import model.type.longJfrType;

public class ClassLoadingStatistics {

    public final static String eventName = "jdk.ClassLoadingStatistics";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType LOADED_CLASS_COUNT = new longJfrType("loadedClassCount", eventName);
    public final static longJfrType UNLOADED_CLASS_COUNT = new longJfrType("unloadedClassCount", eventName);

}
