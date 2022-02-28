
package model;

import model.type.MethodJfrType;
import model.type.StringJfrType;
import model.type.ThreadJfrType;
import model.type.booleanJfrType;
import model.type.intJfrType;
import model.type.longJfrType;
import model.type.shortJfrType;

public class Compilation {

    public final static String eventName = "jdk.Compilation";
    public final static longJfrType START_TIME = new longJfrType("startTime", eventName);
    public final static longJfrType DURATION = new longJfrType("duration", eventName);
    public final static ThreadJfrType EVENT_THREAD = new ThreadJfrType("eventThread", eventName);
    public final static intJfrType COMPILE_ID = new intJfrType("compileId", eventName);
    public final static StringJfrType COMPILER = new StringJfrType("compiler", eventName);
    public final static MethodJfrType METHOD = new MethodJfrType("method", eventName);
    public final static shortJfrType COMPILE_LEVEL = new shortJfrType("compileLevel", eventName);
    public final static booleanJfrType SUCCEDED = new booleanJfrType("succeded", eventName);
    public final static booleanJfrType IS_OSR = new booleanJfrType("isOsr", eventName);
    public final static longJfrType CODE_SIZE = new longJfrType("codeSize", eventName);
    public final static longJfrType INLINED_BYTES = new longJfrType("inlinedBytes", eventName);

}
