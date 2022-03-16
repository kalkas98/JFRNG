# JFRNG
An extension to the TestNG framework that allows developers to collect data via Java Flight Recorder during testing.

Tests can be configured to record any JFR event. JFR events in OpenJDK 17 are documented here: https://bestsolution-at.github.io/jfr-doc/openjdk-17.html.

JFRNG requires Java 17 and TestNG(not sure if it is compatible with all TestNG versions...)

## Usage
To start and stop JFR recordings, a JfrController is needed in the test class. **It must be named "controller" and be declared in the class exactly like this:**

`public JfrController controller = new JfrController();`

### Annotations
The following annotations can be used to configure test and record JFR events in various ways:
- `@RecordJfrEvents` - Enables JFRNG for the test. Takes an array of event names that specifies what events to record.
- `@RecordWithProfile` - Enables a profile for the recording. A profile enables a predefined set of events. The profile name is given as an argument.
- `@DumpJfrToDisk` - Record and save a .jfr file to the disk. Takes the path to the file as an argument.
- `@RecordRemote` - Record JFR events on a remote JVM that has a platform MBeanServer attached to the a JMX service URL. Takes the JMX service url as argument. 

### Simple example
An example to illustrate usage of the framework
```
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
