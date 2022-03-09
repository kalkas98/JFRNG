package jfrng.recording.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to save a jfr recording to disk
 * Takes a path to the new recording file as a parameter
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DumpJfrToDisk
{
	public String value() default "recording.jfr";
}
