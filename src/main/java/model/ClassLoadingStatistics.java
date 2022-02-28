
package model;


public class ClassLoadingStatistics {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField LOADED_CLASS_COUNT = new JfrField("loadedClassCount", "long");
    public final static JfrField UNLOADED_CLASS_COUNT = new JfrField("unloadedClassCount", "long");

}
