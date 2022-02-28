
package model;


public class GarbageCollection {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField DURATION = new JfrField("duration", "long");
    public final static JfrField GC_ID = new JfrField("gcId", "int");
    public final static JfrField NAME = new JfrField("name", "String");
    public final static JfrField CAUSE = new JfrField("cause", "String");
    public final static JfrField SUM_OF_PAUSES = new JfrField("sumOfPauses", "long");
    public final static JfrField LONGEST_PAUSE = new JfrField("longestPause", "long");

}
