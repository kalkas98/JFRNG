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
import jfrng.recording.MetricProvider;
import jfrng.recording.RecordingProfile;
import jfrng.recording.annotation.RecordJfrEvents;
import jfrng.recording.annotation.RecordRemote;
import jfrng.recording.annotation.RecordWithProfile;

import remote.IGreeter;

public class RemoteRecorderTest
{
	public MetricProvider provider = new MetricProvider();
	
	@RecordJfrEvents(ThreadStart.EVENT)
	@RecordRemote(GreetServer.URL)
	@RecordRemote(WelcomeServer.URL)
	@Test(enabled = true)
	public void testRemoteRecording()
	{
		try
		{
			Registry registry = LocateRegistry.getRegistry();
			IGreeter welcomeStub = (IGreeter) registry.lookup(WelcomeServer.BINDING_NAME);
			IGreeter greetStub = (IGreeter) registry.lookup(GreetServer.BINDING_NAME);
			
			System.out.println(welcomeStub.Greet());
			System.out.println(greetStub.Greet());
			Thread.sleep(2000); //To ensure the remote events are processed before we stop recording
								//Should find some way to sync if possible
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		provider.stopRecording();

		Predicate<RecordedEvent> pred = event -> event.hasField("parentThread") && 
				event.getThread("parentThread").getJavaName().startsWith("RMI");
		provider.getEventStream().forEach(System.out::println);
		assertTrue(provider.getEventStream().filter(pred).count() > 0);
		
		

	}
}
