import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import jfrng.model.event.GarbageCollection;
import jfrng.recording.JfrController;
import jfrng.recording.JfrResult;
import jfrng.recording.annotation.RecordJfrEvents;
import testUtil.Bar;
import testUtil.FooEvent;

public class JfrResultTest
{
	public JfrController controller = new JfrController();
	

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
	
	@RecordJfrEvents({
		FooEvent.EVENT
	})
	@Test
	public void filterByClassShouldReturnTwoFooEvents()
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

		
		long barEventCountInMainThread = result.filterOnClass(Bar.class).count();
		assertTrue(barEventCountInMainThread == 2);
	}
	
	@RecordJfrEvents({
		GarbageCollection.EVENT
	})
	@Test
	public void hasFieldWithValueShouldReturnTrue()
	{
		Bar b = new Bar();
		b.foo();
		System.gc();
		JfrResult result = controller.stopRecording();
		result.stream().forEach(System.out::println);
		assertTrue(result.containsFieldWithValue(GarbageCollection.CAUSE, "System.gc()"));
	}
}
