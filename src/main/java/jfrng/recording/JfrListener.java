package jfrng.recording;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import jfrng.recording.annotation.DumpJfrToDisk;
import jfrng.recording.annotation.RecordJfrEvents;
import jfrng.recording.annotation.RecordRemote;
import jfrng.recording.annotation.RecordWithProfile;
import jfrng.recording.annotation.RemoteRecorders;

/**
 * 
 * TestNG Listener that invokes methods before and after tests
 *
 */
public class JfrListener implements IInvokedMethodListener
{


	/**
	 * Invoked before every TestNG test
	 */
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		
		RecordingConfig rc;
		//Get test method object that contains annotations
		Method m = method.getTestMethod().getConstructorOrMethod().getMethod();
		
		
		if (m.isAnnotationPresent(RecordJfrEvents.class))
		{
			String[] enabledEvents = m.getAnnotation(RecordJfrEvents.class).value();

			try
			{
				rc = new RecordingConfig(enabledEvents);
				
				//Enable recording profile if annotaion is present
				if (m.isAnnotationPresent(RecordWithProfile.class))
				{
					List<RecordingProfile> profiles = Arrays.asList(m.getAnnotation(RecordWithProfile.class).value());
					for (RecordingProfile profile : profiles) {
						rc.EnableProfile(profile);
					}
				}
				
				//Enable jfr disk recording if annotation is present
				if(m.isAnnotationPresent(DumpJfrToDisk.class))
				{
					rc.setPath(m.getAnnotation(DumpJfrToDisk.class).value());
					rc.setRecordToDisk(true);
				}
				
				if(m.isAnnotationPresent(RecordRemote.class) || m.isAnnotationPresent(RemoteRecorders.class))
				{
					rc.setRemoteRecordingEnabled(true);
					RecordRemote[] remoteAnnotations =  m.getAnnotationsByType(RecordRemote.class);
					for (RecordRemote annotation : remoteAnnotations)
					{
						rc.addRemoteUrl(annotation.value());
					}
				}
				
				
				JfrController controller = getRecorderInstance(method);
				EventRecorder recorder = new EventRecorder(rc);
				controller.setRecorder(recorder);
				recorder.startRecording();
				recorder.clear();//Clear events recorded during startup
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	}

	/**
	 * Invoked after each TestNG test
	 */
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		Method m = method.getTestMethod().getConstructorOrMethod().getMethod();
		if (m.isAnnotationPresent(RecordJfrEvents.class))
		{
			JfrController provider = getRecorderInstance(method);
			if(provider.isRecording())
			{
				provider.stopRecording();				
			}
		}
	}

	
	public static final String JFR_CONTROLLER_NAME = "controller";
	
	/**
	 * Gets the JfrController instance in the test class
	 * @param method - TestNG test method
	 * @return JfrController instance of the test class
	 */
	private JfrController getRecorderInstance(IInvokedMethod method)
	{
		Object obj = method.getTestMethod().getInstance();
		try
		{
			Field f = obj.getClass().getField(JFR_CONTROLLER_NAME);
			return (JfrController) f.get(obj);
		}
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}