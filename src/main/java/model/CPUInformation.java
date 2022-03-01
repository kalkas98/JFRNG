
package model;

import model.type.StringJfrType;
import model.type.intJfrType;
import model.type.longJfrType;

public class CPUInformation {

    public final static String EVENT = "jdk.CPUInformation";
    public final static longJfrType START_TIME = new longJfrType("startTime", EVENT);
    public final static StringJfrType CPU = new StringJfrType("cpu", EVENT);
    public final static StringJfrType DESCRIPTION = new StringJfrType("description", EVENT);
    public final static intJfrType SOCKETS = new intJfrType("sockets", EVENT);
    public final static intJfrType CORES = new intJfrType("cores", EVENT);
    public final static intJfrType HW_THREADS = new intJfrType("hwThreads", EVENT);

}
