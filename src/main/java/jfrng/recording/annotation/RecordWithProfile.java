package jfrng.recording.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jfrng.recording.RecordingProfile;

/**
 * Enables a profile for the JFR recording.
 * Profiles enables the recording of a set of events.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RecordWithProfile
{
	public RecordingProfile[] value(); 
}
