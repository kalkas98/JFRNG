


import jdk.jfr.Event;
import jdk.jfr.Name;
import jdk.jfr.Enabled;


/**
 *	Event for synching the JFR recording stream thread with the calling thread
 */
@Name(FooEvent.EVENT)
@Enabled(false)
public class FooEvent extends Event {
	public static final String EVENT = "FOO_EVENT";
}
