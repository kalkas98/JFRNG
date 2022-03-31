import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import jfrng.model.event.GarbageCollection;
import jfrng.model.event.ThreadStart;
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
		ThreadStart.EVENT
	})
	@Test
	public void Test1()
	{

		Thread t = new Thread();
		t.start();

		try
		{
			t.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}
	
	@RecordJfrEvents({
		ThreadStart.EVENT
	})
	@Test
	public void Test2()
	{

		Thread t = new Thread();
		t.start();

		try
		{
			t.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
