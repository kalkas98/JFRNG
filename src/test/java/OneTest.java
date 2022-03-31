import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import jfrng.model.event.GarbageCollection;
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
public class OneTest
{
	public JfrController controller = new JfrController("asdf");


	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.MEMORY)
	@Test
	public void MemoryTest()
	{
		System.out.println("1");

		Bar b = new Bar();
		b.mem();
		JfrResult result = controller.stopRecording();

		String currentThread = Thread.currentThread().getName();
		long allocatedMb = result.getAllocatedMemoryInThread(currentThread) / 1_000_000;
		result.stream().forEach(e -> System.out.println(e.getEventType().getName()));

		System.out.println("Allocated: " + allocatedMb);
		assertTrue(allocatedMb < 500);
	}
	
	
	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.FILE_IO)
	@Test
	public void FileIO() throws InterruptedException
	{
		System.out.println("2");

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
		result.stream().forEach(e -> System.out.println(e.getEventType().getName()));

		assertTrue(result.getFileIOWrite("filename.txt") == 11);
		assertTrue(result.getFileIORead("filename.txt") == 11);
	}
	
	@RecordJfrEvents(ThreadStart.EVENT)
	//@RecordWithProfile()
	@Test
	public void FileIO2() throws InterruptedException
	{
		System.out.println("3");

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
		result.stream().forEach(e -> System.out.println(e.getEventType().getName()));
		assertTrue(result.getFileIOWrite("filename.txt") == 11);
		assertTrue(result.getFileIORead("filename.txt") == 11);
	}

}
