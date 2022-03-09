package jfrng.recording.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Enables recording JFR events via a jfr stream
 * The given events in the String array will be recorded by the jfr stream
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RecordJfrEvents {
	public String[] value() default {};
}
