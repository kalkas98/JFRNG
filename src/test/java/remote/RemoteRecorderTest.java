package remote;
import static org.testng.Assert.assertTrue;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.function.Predicate;

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
	@RecordRemote(Server.URL)
	@RecordRemote(AltServer.URL)
	@Test(enabled = true)
	public void testRemoteRecording()
	{
		try
		{
			Registry registry = LocateRegistry.getRegistry();
			
			IGreeter stub = (IGreeter) registry.lookup("Greeter");
			IGreeter stub2 = (IGreeter) registry.lookup("Greeter2");
			System.out.println(stub.Greet());
			System.out.println(stub2.Greet());
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
		assertTrue(provider.getEventStream().filter(pred).count() > 0);
		
		

	}
}
