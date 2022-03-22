package jfrng.recording.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Disable the recording of stacktraces when recording events.
 * Can be a good idea if you want to reduce the overhead.
 * Some of the methods in JfrResult that depend on dat gathered by stacktraces wont work when enabling this option.
 *  
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DisableStacktrace
{

}
