package recording;

import jdk.jfr.Event;
import jdk.jfr.Name;


/**
 *	Event for synching the JFR recording stream thread with the calling thread
 */
@Name(SynchronizationEvent.SYNCH_EVENT_NAME)
public class SynchronizationEvent extends Event {
	public static final String SYNCH_EVENT_NAME = "SYNCHRONIZATION_EVENT";
}

