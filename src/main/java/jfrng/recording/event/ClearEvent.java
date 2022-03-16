package jfrng.recording.event;

import jdk.jfr.Event;
import jdk.jfr.Name;

/**
 * Custom event for clearing recorded events
 *
 */
@Name(ClearEvent.CLEAR_EVENT_NAME)
public class ClearEvent extends Event {
	public static final String CLEAR_EVENT_NAME = "CLEAR_EVENT";
}