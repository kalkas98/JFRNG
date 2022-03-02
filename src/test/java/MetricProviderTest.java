import static org.testng.Assert.assertTrue;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import model.event.CPUInformation;
import model.event.FileWrite;
import model.event.GarbageCollection;
import model.event.SystemGC;
import model.event.ThreadSleep;
import model.event.ThreadStart;
import prototype.DumpJfrToDisk;
import prototype.MetricProvider;
import prototype.RecordJfrEvents;
import prototype.RecordWithProfile;
import prototype.RecordingProfile;
import util.Bar;

@Listeners({ prototype.JfrListener.class })
public class MetricProviderTest
{
	
	public MetricProvider provider = new MetricProvider();

	@RecordJfrEvents(GarbageCollection.EVENT)
	@RecordWithProfile(RecordingProfile.MEMORY)
	@Test
	public void TestBasicRecordingWithSingleEventAndProfile()
	{

		Bar b = new Bar();
		b.foo();
		System.gc();
		provider.stopRecording();
		
		String currentThread  = Thread.currentThread().getName();
		
		assertTrue(provider.getTLABAllocationInThread(currentThread) > 0);
		assertTrue(provider.filterOnEvent(GarbageCollection.EVENT).count() > 0);

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
				System.out.println(data);
			}
			myReader.close();
		}
		catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		provider.stopRecording();
		
		assertTrue(provider.getFileIORead("filename.txt") > 0);
		assertTrue(provider.getFileIOWrite("filename.txt") > 0);
		assertTrue(provider.getTLABAllocationInThread(Thread.currentThread().getName()) > 0);
		/*
		System.out.println("Bytes read from filename.txt: " + provider.getFileIORead("filename.txt"));
		System.out.println("Bytes written to filename.txt: " + provider.getFileIOWrite("filename.txt"));
		System.out.println("Allocated bytes in main: " + provider.getTLABAllocationInThread(Thread.currentThread().getName()));
		*/
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
		System.out.println(provider.getSocketIOWrite());
		System.out.println(provider.getSocketIORead());

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
		b.foo();
		System.gc();
		provider.stopRecording();
		assertTrue(provider.getGCPauseSum(TimeUnit.NANOSECONDS) > 0);
		assertTrue(provider.getThreadsStarted() > 0);
	}
	
	@RecordJfrEvents({
		GarbageCollection.EVENT,
		ThreadSleep.EVENT,
		CPUInformation.EVENT
	})
	@Test
	public void TestFilterMethods() throws InterruptedException
	{

		Bar b = new Bar();
		b.foo();
		System.gc();
		Thread.sleep(100);
		provider.stopRecording();
		String currentThread  = Thread.currentThread().getName();

		
		assertTrue(provider.filterOnEvent(GarbageCollection.EVENT).count() > 0);
		assertTrue(provider.filterOnField(GarbageCollection.DURATION, val -> val > 0 ).count() > 0);
		assertTrue(provider.filterOnField(GarbageCollection.CAUSE, "System.gc()").count() > 0);
		assertTrue(provider.filterOnField(GarbageCollection.GC_ID, id -> id > 0).count() > 0);
		assertTrue(provider.filterOnField(ThreadSleep.EVENT_THREAD, currentThread).count() > 0);


	}
	
	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.MEMORY)
	@Test
	public void test()
	{
		System.out.println(provider.getTLABAllocation());
	}
	
}
