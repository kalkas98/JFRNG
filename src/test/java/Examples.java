import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import jfrng.model.event.GarbageCollection;
import jfrng.model.event.ThreadStart;
import jfrng.recording.MetricProvider;
import jfrng.recording.RecordingProfile;
import jfrng.recording.annotation.DumpJfrToDisk;
import jfrng.recording.annotation.RecordJfrEvents;
import jfrng.recording.annotation.RecordWithProfile;

public class Examples
{
	
	public MetricProvider provider = new MetricProvider();
	
	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.MEMORY)
	@Test
	public void MemoryTest()
	{
		
		Bar b = new Bar();
		b.mem();
		provider.stopRecording();
		String currentThread = Thread.currentThread().getName();
		long allocatedMb = provider.getTLABAllocationInThread(currentThread) / 1_000_000;	
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

		provider.stopRecording();
		
		assertTrue(provider.getFileIOWrite("filename.txt") == 11);
		assertTrue(provider.getFileIORead("filename.txt") == 11);
	}
	
	@RecordJfrEvents(GarbageCollection.EVENT)
	@Test
	public void GarbageCollection() 
	{
		System.gc();
		provider.stopRecording();
		
		long SystemGcCount = provider.filterOnField(GarbageCollection.CAUSE, "System.gc()").count();
		long pauseDuration = provider.getGCPauseSum(TimeUnit.MILLISECONDS);
		
		assertTrue(pauseDuration < 20);
		assertTrue(SystemGcCount == 1);
	}
	
	
	@RecordJfrEvents(ThreadStart.EVENT)
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
		provider.stopRecording();
		
		String thisThread = Thread.currentThread().getName();
		long threadsStarted = provider.getThreadsStarted(thisThread);
		
		assertTrue(threadsStarted == NR_THREADS);
	}
	
	@RecordJfrEvents(FooEvent.EVENT)
	@Test
	public void CustomEvent() 
	{
		Bar b = new Bar();
		b.foo(); //foo() commits the custom FooEvent event to JFR
		provider.stopRecording();
		
		long customEventCount = provider.filterOnEvent(FooEvent.EVENT).count();
		
		assertTrue(customEventCount == 1);
	}
	
	
	

}
