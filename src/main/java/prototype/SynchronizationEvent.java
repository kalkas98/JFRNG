package prototype;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;


@Name(SynchronizationEvent.SYNCH_EVENT_NAME)
public class SynchronizationEvent extends Event {
	public static final String SYNCH_EVENT_NAME = "SYNCHRONIZATION_EVENT";
}

