import static org.testng.Assert.assertTrue;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import jfrng.model.event.CPUInformation;
import jfrng.model.event.GarbageCollection;
import jfrng.model.event.ThreadSleep;
import jfrng.model.event.ThreadStart;
import jfrng.recording.JfrController;
import jfrng.recording.JfrResult;
import jfrng.recording.RecordingProfile;
import jfrng.recording.annotation.DisableStacktrace;
import jfrng.recording.annotation.DumpJfrToDisk;
import jfrng.recording.annotation.RecordJfrEvents;
import jfrng.recording.annotation.RecordWithProfile;
import testUtil.Bar;
import testUtil.FooEvent;

public class JfrngTest
{
	
	public JfrController controller = new JfrController();

	@RecordJfrEvents(GarbageCollection.EVENT)
	@RecordWithProfile(RecordingProfile.MEMORY)
	@Test
	public void TestBasicRecordingWithSingleEventAndProfile()
	{
		Bar b = new Bar();
		b.foo();
		System.gc();
		
		JfrResult result = controller.stopRecording();
		String currentThread  = Thread.currentThread().getName();
		
		assertTrue(result.getAllocatedMemoryInThread(currentThread) > 0);
		assertTrue(result.filterOnEvent(GarbageCollection.EVENT).count() > 0);
	}

	@RecordJfrEvents
	@RecordWithProfile({
		RecordingProfile.FILE_IO,
		RecordingProfile.MEMORY
	})
	@DumpJfrToDisk
	@Test
	public void testMultipleProfilesAndNoEventWithDiskRecording() throws InterruptedException
	{
		Bar b = new Bar();
		b.foo();
		try
		{
			File myObj = new File("filename.txt");

			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write("Git for Windows provides a BASH emulation used to run Git from the command line. *NIX users should feel right at home, as the BASH emulation behaves just like the \"git\" command in LINUX and UNIX environments.\r\n");
			myWriter.close();

			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();
			}
			myReader.close();
		}
		catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		JfrResult result = controller.stopRecording();
		
		assertTrue(result.getFileIORead("filename.txt") > 0);
		assertTrue(result.getFileIOWrite("filename.txt") > 0);
		assertTrue(result.getAllocatedMemoryInThread(Thread.currentThread().getName()) > 0);
	}

	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.SOCKET_IO)
	@Test(enabled=false)
	public void TestSocketIO() throws IOException, InterruptedException
	{
		String a = "The term socket programming refers to writing programs that execute across multiple computers in which the devices are all connected to each other using a network.\n"
				+ "\n"
				+ "There are two communication protocols that we can use for socket programming: User Datagram Protocol (UDP) and Transfer Control Protocol (TCP).\n"
				+ "\n"
				+ "The main difference between the two is that UDP is connection-less, meaning there's no session between the client and the server, while TCP is connection-oriented, meaning an exclusive connection must first be established between the client and server for communication to take place.\n"
				+ "\n"
				+ "This tutorial presents an introduction to sockets programming over TCP/IP networks, and demonstrates how to write client/server applications in Java. UDP isn't a mainstream protocol, and as such, might not be encountered often.";
		Socket s = new Socket("127.0.0.1", 6666);
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		dout.writeUTF( a);
		dout.flush();
		dout.close();
		s.close();
		
		JfrResult result = controller.stopRecording();

		System.out.println(result.getSocketIOWrite());
		System.out.println(result.getSocketIORead());
	}


	@RecordJfrEvents({
		GarbageCollection.EVENT,
		ThreadStart.EVENT
	})
	@DumpJfrToDisk("gc.jfr")
	@Test
	public void TestMultipleEventsNoProfileAndDiskRecordingWithPath() throws InterruptedException
	{
		Bar b = new Bar();
		Thread t = new Thread();
		t.start();
		b.foo();
		System.gc();
		JfrResult result = controller.stopRecording();
		assertTrue(result.getGCPauseSum(TimeUnit.NANOSECONDS) > 0);
		assertTrue(result.getThreadsStarted() > 0);
	}
	
	@RecordJfrEvents({
		ThreadSleep.EVENT,
		GarbageCollection.EVENT,
		testUtil.FooEvent.EVENT
	})
	@DisableStacktrace
	@DumpJfrToDisk("gc.jfr")
	@Test
	public void TestFilterMethods() throws InterruptedException
	{

		Bar b = new Bar();
		b.foo();
		System.gc();
		Thread.sleep(100);
		JfrResult result = controller.stopRecording();
		
		String currentThread  = Thread.currentThread().getName();
		assertTrue(result.hasEvent(GarbageCollection.EVENT));
		assertTrue(result.anyMatchPredicate(GarbageCollection.DURATION, duration -> duration > 10 ));
		assertTrue(result.containsFieldWithValue(GarbageCollection.CAUSE, "System.gc()"));
		
		assertTrue(result.anyMatchPredicate(GarbageCollection.GC_ID, id -> id > 0));
		assertTrue(result.filterByThread(currentThread).hasEvent(ThreadSleep.EVENT));
	}
	
	@RecordJfrEvents({
		FooEvent.EVENT
	})
	@DisableStacktrace
	@Test
	public void TestDisableStacktraceAndFilterOnClass()
	{
		Bar b = new Bar();
		b.foo();
		JfrResult result = controller.stopRecording();
		
		long barEventCount = result.filterOnClass(Bar.class).count();
		assertTrue(barEventCount == 0);
	}
	
	@RecordJfrEvents({
		FooEvent.EVENT
	})
	@Test
	public void TestEnableStacktraceAndFilterOnClass()
	{
		Bar b = new Bar();
		b.foo();
		JfrResult result = controller.stopRecording();
		
		long barEventCount = result.filterOnClass(Bar.class).count();
		assertTrue(barEventCount == 1);
	}
}
