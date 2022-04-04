package jfrng.recording;

import java.io.IOException;
import java.nio.file.Path;

import org.testng.ITestContext;
import org.testng.ITestListener;

import jdk.jfr.Recording;
/**
 * Used to create a JFR recoding for a test class
 * 
 * This listener is not included automatically for test classes and has to be added using the TestNG listener annotation
 *
 */
public class TestClassListener implements ITestListener
{

	@Override
	public void onStart(ITestContext context)
	{
		Recording recording = new Recording();
		recording.start();
		context.setAttribute("recording", recording);
		
		ITestListener.super.onStart(context);
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		Recording recording = (Recording) context.getAttribute("recording");
		
		try
		{
			recording.dump(Path.of("diskRecording.jfr"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		recording.stop();
		ITestListener.super.onFinish(context);
	}
}
