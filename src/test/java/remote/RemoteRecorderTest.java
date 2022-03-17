package remote;
import static org.testng.Assert.assertTrue;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.function.Predicate;

import org.testng.TestNG;
import org.testng.annotations.Test;

import jdk.jfr.consumer.RecordedEvent;
import jfrng.model.event.GarbageCollection;
import jfrng.model.event.ThreadStart;
import jfrng.recording.JfrController;
import jfrng.recording.JfrResult;
import jfrng.recording.RecordedJfrEvent;
import jfrng.recording.RecordingProfile;
import jfrng.recording.annotation.RecordJfrEvents;
import jfrng.recording.annotation.RecordRemote;
import jfrng.recording.annotation.RecordWithProfile;

import remote.IGreeter;

public class RemoteRecorderTest
{
	public JfrController controller = new JfrController();
	
	@RecordJfrEvents(ThreadStart.EVENT)
	//@RecordRemote(GreetServer.URL)
	@RecordRemote(WelcomeServer.URL)
	@Test(enabled = false)
	public void testRemoteRecording()
	{
		try
		{
			Registry registry = LocateRegistry.getRegistry();
			IGreeter welcomeStub = (IGreeter) registry.lookup(WelcomeServer.BINDING_NAME);
			//IGreeter greetStub = (IGreeter) registry.lookup(GreetServer.BINDING_NAME);
			
			System.out.println(welcomeStub.Greet());
			//System.out.println(greetStub.Greet());
			Thread.sleep(2000); //To ensure the remote events are processed before we stop recording
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		JfrResult result = controller.stopRecording();


		Predicate<RecordedJfrEvent> pred = event -> event.hasField(ThreadStart.PARENT_THREAD) && 
				event.getThread(ThreadStart.PARENT_THREAD).getJavaName().startsWith("RMI");
		//result.stream().forEach(System.out::println);
		assertTrue(result.filter(pred).count() > 0);
		
		

	}
}
