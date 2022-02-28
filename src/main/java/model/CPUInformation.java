
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CPUInformation {

    public final static String eventName = "jdk.CPUInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static StringJfrType CPU = new StringJfrType("cpu", eventName);
    public final static StringJfrType DESCRIPTION = new StringJfrType("description", eventName);
    public final static intJfrType SOCKETS = new intJfrType("sockets", eventName);
    public final static intJfrType CORES = new intJfrType("cores", eventName);
    public final static intJfrType HW_THREADS = new intJfrType("hwThreads", eventName);

}
