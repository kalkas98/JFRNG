import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import jfrng.model.event.GarbageCollection;
import jfrng.recording.JfrController;
import jfrng.recording.JfrResult;
import jfrng.recording.JfrTestClassListener;
import jfrng.recording.annotation.RecordJfrEvents;
import testUtil.Bar;
import testUtil.FooEvent;

@Listeners({ JfrTestClassListener.class })
public class OneTest
{
	public JfrController controller = new JfrController("asdf");


	@RecordJfrEvents({
		FooEvent.EVENT
	})
	@Test
	public void filterByThreadAndClassShouldReturnOneFooEvent()
	{
		Bar b = new Bar();
		b.foo();
		Thread t = new Thread(() -> b.foo());
		t.start();

		try
		{
			t.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		JfrResult result = controller.stopRecording();
		String thisThread = Thread.currentThread().getName();
		
		
		long barEventCountInMainThread = result.filterByThread(thisThread).filterOnClass(Bar.class).count();
		assertTrue(barEventCountInMainThread == 1);
	}

}
