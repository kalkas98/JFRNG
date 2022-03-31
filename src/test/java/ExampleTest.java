import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import jfrng.model.event.GarbageCollection;
import jfrng.model.event.ThreadEnd;
import jfrng.model.event.ThreadStart;
import jfrng.recording.JfrController;
import jfrng.recording.JfrResult;
import jfrng.recording.JfrTestClassListener;
import jfrng.recording.RecordingProfile;
import jfrng.recording.annotation.RecordJfrEvents;
import jfrng.recording.annotation.RecordWithProfile;
import testUtil.Bar;
import testUtil.FooEvent;

@Listeners({ JfrTestClassListener.class })
public class ExampleTest
{
	
	public JfrController controller = new JfrController();
	
	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.MEMORY)
	@Test
	public void MemoryTest()
	{
		
		Bar b = new Bar();
		b.mem();
		JfrResult result = controller.stopRecording();

		String currentThread = Thread.currentThread().getName();
		long allocatedMb = result.getAllocatedMemoryInThread(currentThread) / 1_000_000;	
		System.out.println("Allocated: " + allocatedMb);
		assertTrue(allocatedMb < 500);
	}
	
	
	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.FILE_IO)
	@Test
	public void FileIO() throws InterruptedException
	{

		try
		{
			File file = new File("filename.txt");
			FileWriter writer = new FileWriter("filename.txt");
			writer.write("Lorem Ipsum");
			writer.close();
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine())
			{
				String data = reader.nextLine();
			}
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		JfrResult result = controller.stopRecording();
		result.stream().forEach(System.out::println);
		assertTrue(result.getFileIOWrite("filename.txt") == 11);
		assertTrue(result.getFileIORead("filename.txt") == 11);
	}
	
	@RecordJfrEvents(GarbageCollection.EVENT)
	@Test
	public void GarbageCollection() 
	{
		System.gc();
		JfrResult result = controller.stopRecording();
		long SystemGcCount = result.filterOnField(GarbageCollection.CAUSE, "System.gc()").count();
		long pauseDuration = result.getGCPauseSum(TimeUnit.MILLISECONDS);
		
		assertTrue(pauseDuration < 20);
		assertTrue(SystemGcCount == 1);
	}
	
	@RecordJfrEvents({
		ThreadStart.EVENT,
		ThreadEnd.EVENT
		
		})
	@Test
	public void ThreadsStarted() 
	{
		int NR_THREADS = 10;
		
		Thread[] thread = new Thread[NR_THREADS];
		for (int i = 0; i < NR_THREADS; i++)
		{
			thread[i] = new Thread();
			thread[i].start();
		}
		JfrResult result = controller.stopRecording();
		
		String thisThread = Thread.currentThread().getName();

		long threadsStarted = result.getThreadsStarted(thisThread);
		assertTrue(threadsStarted == NR_THREADS);
	}
	
	@RecordJfrEvents(FooEvent.EVENT)
	@Test
	public void CustomEvent() 
	{
		Bar b = new Bar();
		b.foo(); //foo() commits the custom FooEvent event to JFR
		JfrResult result = controller.stopRecording();
		
		long customEventCount = result.filterOnEvent(FooEvent.EVENT).count();
		
		assertTrue(customEventCount == 1);
	}

}
