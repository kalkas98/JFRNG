# JFRNG
An extension to the TestNG framework that allows developers to collect data via Java Flight Recorder during testing.

Tests can be configured to record any JFR event. JFR events available in OpenJDK 17 are documented here: https://bestsolution-at.github.io/jfr-doc/openjdk-17.html.

JFRNG requires at least Java 16 and TestNG.

## Usage
To start and stop JFR recordings, a JfrController is needed in the test class. **It must be named "controller" and be declared in the class exactly like this:**

`public JfrController controller = new JfrController();`

### Annotations
The following annotations can be used to configure a test and record JFR events in various ways:
- `@RecordJfrEvents` - Enables JFRNG for the test. Takes an array of event names that specifies what events to record.
- `@RecordWithProfile` - Enables a profile for the recording. A profile enables a predefined set of events. The profile name is given as an argument.
- `@DumpJfrToDisk` - Record and save a .jfr file to the disk. Takes a filepath as an argument.
- `@RecordRemote` - Record JFR events on a remote JVM that has a platform MBeanServer attached to the a JMX service URL. Takes the JMX service url as argument. 

### Example
Let's take a look at an example to illustrate usage of the framework. In the following example JFRNG is used to record the ThreadStart event emmited when a new thread is started. 
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

The event name is given as an argument to `@RecordJfrEvents` by passing ThreadStart.Event as an argument. The same can be done with any other event, all event classes are found in the package `jfrng.model.event`. 

Before the test method is invoked the JFR recording begins automaticly. The line `JfrResult result = controller.stopRecording();` stops the recording and saves the recorded data in a JfrResult object. The JfrResult class contains a number of methods that can be used to access the results. Here the method getThreadsStarted(String thread) is used to get the number of threads started from the main thread.
