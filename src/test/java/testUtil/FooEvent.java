package testUtil;
import jdk.jfr.Event;
import jdk.jfr.Name;
import jdk.jfr.Enabled;


/**
 *	Custom JFR event used for testing purposes
 */
@Name(FooEvent.EVENT)
@Enabled(false)
public class FooEvent extends Event {
	public static final String EVENT = "FOO_EVENT";
}
