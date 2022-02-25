import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import jdk.jfr.consumer.RecordedEvent;
import prototype.Bar;
import prototype.DumpJfrToDisk;
import prototype.EventRecorder;
import prototype.JfrEvent;
import prototype.MetricProvider;
import prototype.RecordJfrEvents;
import prototype.RecordWithProfile;
import prototype.RecordingProfile;

@Listeners({ prototype.JfrListener.class })
public class NewTest
{
	
	public MetricProvider provider = new MetricProvider();

	@RecordJfrEvents({ JfrEvent.THREAD_START })
	@RecordWithProfile(RecordingProfile.MEMORY)
	@Test
	public void a()
	{

		Bar b = new Bar();
		b.foo();
		System.gc();

		provider.getEventStream().forEach(System.out::println);
		System.out.println("Allocated: " + provider.getTLABAllocationInThread(Thread.currentThread().getName()));
		// System.out.println("asdf " +
		// recorder.getDurationAggregate(JfrEvent.GARBAGE_COLLECTION, "duration"));

	}

	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.FILE_IO)
	@RecordWithProfile(RecordingProfile.MEMORY)
	@DumpJfrToDisk
	@Test
	public void memoryTest() throws InterruptedException
	{

		Bar b = new Bar();
		b.foo();
		System.gc();

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

		provider.reset();
		provider.stopRecording();

		System.out.println(provider.getFileIORead("filename.txt"));
		System.out.println(":(");
		System.out.println(provider.getFileIOWrite("filename.txt"));
		System.out.println(provider.getTLABAllocationInThread(Thread.currentThread().getName()));
		provider.getEventStream().forEach(System.out::println);

	}

	@RecordJfrEvents
	@RecordWithProfile(RecordingProfile.SOCKET_IO)
	//@Test
	public void b() throws IOException, InterruptedException
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


	@RecordJfrEvents({ JfrEvent.GARBAGE_COLLECTION })
	@DumpJfrToDisk("gc.jfr")
	@Test
	public void c() throws InterruptedException
	{
		List<Integer> lst = new ArrayList<>(5000);
		Bar b = new Bar();
		b.foo();
		System.gc();
		System.out.println(provider.getGCPauseSum());
	}
}
