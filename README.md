# JFRNG
An extension to the TestNG framework that allows developers to collect data via Java Flight Recorder during testing.

Tests can be configured to record any JFR event. JFR events available in OpenJDK 17 are documented here: https://bestsolution-at.github.io/jfr-doc/openjdk-17.html.

JFRNG requires at least Java 16 and TestNG.

## Usage
Run `mvn install` to install the package into the local repository, then add it as a dependency to your pom file

```xml
<dependency>
	<groupId>jfrng</groupId>
	<artifactId>JFRNG</artifactId>
	<version>0.0.2-SNAPSHOT</version>
</dependency>
```


To start and stop JFR recordings, a JfrController is needed in the test class. **It must be named "controller" and be declared in the class exactly like this:**

`public JfrController controller = new JfrController();`

To stop the recording and get the result of the recording write `JfrResult result = controller.stopRecording()` in the test. To see documenation for the ways you can access the results via the JfrResult object view the JfrResult class.
### Annotations
The following annotations can be used to configure a test and record JFR events in various ways:
- `@RecordJfrEvents` - Enables JFRNG for the test. Takes an array of event names that specifies what events to record.
- `@RecordWithProfile` - Enables a profile for the recording. A profile enables a predefined set of events. The profile name is given as an argument. One can enable the events individually in `@RecordJfrEvents` just as well, `@RecordWithProfile` is exists to make it more convenient.
- `@DumpJfrToDisk` - Record and save a .jfr file to the disk. Takes a filepath as an argument.
- `@RecordRemote` - Record JFR events on a remote JVM that has a platform MBeanServer attached to the a JMX service URL. Takes the JMX service url as argument. 

### Example
Let's take a look at an example to illustrate usage of the framework. In the following example JFRNG is used to record the ThreadStart event emmited when a new thread is started. 
```java
public class ExampleTest
{
	
	public JfrController controller = new JfrController();
	
	@RecordJfrEvents(ThreadStart.EVENT)
	@Test
	public void ThreadExample() 
	{		
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
}
```

The event name is given as an argument to `@RecordJfrEvents` by passing ThreadStart.Event as an argument. The same can be done with any other event, all event classes are found in the package `jfrng.model.event`. 

Before the test method is invoked the JFR recording begins automaticly. The line `JfrResult result = controller.stopRecording();` stops the recording and saves the recorded data in a JfrResult object. The JfrResult class contains a number of methods that can be used to access the results. Here the method `getThreadsStarted(String thread)` is used to get the number of threads started by the main thread.

### More complex example
Here is a more complex example where multiple annotations are used at the same time
```java
public class TestClass
{
	public JfrController controller = new JfrController();
	
	@RecordJfrEvents({
		GarbageCollection.EVENT,
		ThreadStart.EVENT,
		ThreadEnd.EVENT
	})
	@RecordWithProfile(RecordingProfile.MEMORY)
	@RecordWithProfile(RecordingProfile.SOCKET_IO)
	@DumpJfrToDisk("MyRecording.jfr")
	@Test
	public void ComplexExample() throws InterruptedException
	{
		Bar b = new Bar();
		b.foo();
		
		JfrResult result = controller.stopRecording();
		
		result.stream().forEach(System.out::println); // Print all recorded events
		
		assertTrue(result.getGCPauseSum(TimeUnit.NANOSECONDS) > 0);
		assertTrue(result.getThreadsStarted() > 0);
	}
}
```

### Recording on remote JVMs
Here is an example of how you can record JFR events on a remote JVM. Here we connect to the WelcomeServer(the code can be seen further down bellow) and later make a RMI call to it. Then we stop recording and filter the result from the recording to get only the events that occured on the remote host via the RMI call. Here we only record ThreadStart events, so the events we finally get are the ThreadStart events that occured on the remote host as a consequence of our RMI.
```java
public class RemoteRecorderTest
{
	public JfrController controller = new JfrController();
	
	@RecordJfrEvents(ThreadStart.EVENT)
	@RecordRemote(WelcomeServer.URL)
	@Test
	public void testRemoteRecording()
	{
		try
		{
			Registry registry = LocateRegistry.getRegistry();
			IGreeter welcomeStub = (IGreeter) registry.lookup(WelcomeServer.BINDING_NAME);			
			System.out.println(welcomeStub.Greet());
			Thread.sleep(2000); //To ensure the remote events are processed before we stop recording
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		JfrResult result = controller.stopRecording();
		Predicate<RecordedJfrEvent> pred = event -> event.hasField(ThreadStart.PARENT_THREAD) && 
				event.getThread(ThreadStart.PARENT_THREAD).getJavaName().startsWith("RMI");
		assertTrue(result.filter(pred).count() > 0);
	}
}
```

Code for the server

```java
public class WelcomeServer implements IGreeter
{
	public final static int JMX_PORT = 1920;
	public final static String JMX_HOST = "localhost";
	public final static String URL = "service:jmx:rmi:///jndi/rmi://" + JMX_HOST + ":" + JMX_PORT + "/jmxrmi";
	public final static String BINDING_NAME = "welcome";

	public WelcomeServer()
	{
	}
	
	public static void main(String[] args) throws Exception
	{
		initRMIServer();
		initJMXConnectorServer();
	}

	public String Greet()
	{
		Thread t1 = new Thread();
		t1.start(); // Start a thread to trigger a jfr event
		return "Welcome Traveler!";
	}

	private static void initJMXConnectorServer() throws Exception
	{
		LocateRegistry.createRegistry(JMX_PORT);
		MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
		JMXServiceURL jmxUrl = new JMXServiceURL(URL);
		JMXConnectorServer connectorServer = JMXConnectorServerFactory.newJMXConnectorServer(jmxUrl, null, beanServer);

		connectorServer.start();
	}

	private static void initRMIServer() throws Exception
	{
		WelcomeServer s1 = new WelcomeServer();
		IGreeter remoteObj = (IGreeter) UnicastRemoteObject.exportObject(s1, 0);
		Registry registry = LocateRegistry.getRegistry();
		registry.bind(BINDING_NAME, remoteObj);
	}
}
```

```java
public interface IGreeter extends Remote
{
	public String Greet() throws RemoteException;
}
```
