
package model;


public class CompilerConfiguration {

    public final static JfrField START_TIME = new JfrField("startTime", "long");
    public final static JfrField THREAD_COUNT = new JfrField("threadCount", "int");
    public final static JfrField TIERED_COMPILATION = new JfrField("tieredCompilation", "boolean");

}
