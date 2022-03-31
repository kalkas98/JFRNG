package jfrng.recording;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import jfrng.recording.annotation.DisableStacktrace;
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
				
				//Enable recording profile if annotation is present
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
				
				if(m.isAnnotationPresent(DisableStacktrace.class))
				{
					rc.setStacktraceDisabled(true);
				}
				
				JfrController controller = getControllerInstance(method);
				controller.startTestRecording(rc);
				
				//controller.startTestRecording(config);
				//EventRecorder recorder = new EventRecorder(rc);
				//controller.setRecorder(recorder);
				//recorder.configureRecording();
				
				//ONLY SYNCH AND CLEAR HERE
				controller.reset();//Clear events recorded during startup
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
			JfrController provider = getControllerInstance(method);
			if(provider.isRecording())
			{
				provider.stopRecording();				
			}
		}
	}
	
	/**
	 * Gets the JfrController instance in the test class
	 * @param method - TestNG test method
	 * @return JfrController instance of the test class
	 */
	private JfrController getControllerInstance(IInvokedMethod method)
	{
		Object obj = method.getTestMethod().getInstance();
		JfrController controller = null;
		boolean controllerFound = false;
		try
		{
			Field[] fields = obj.getClass().getDeclaredFields();
			String controllerTypeName = JfrController.class.getTypeName();
			for (Field field : fields)
			{
				String fieldTypeName = field.getGenericType().getTypeName();
				if(fieldTypeName.equals(controllerTypeName))
				{
					if(controllerFound)
						throw new Exception("Multiple JfrControllers found");
					controller = (JfrController) field.get(obj);
					controllerFound = true;
				}
			}
			if(controller != null)
			{
				return controller;
			}
			else
			{
				throw new Exception("No JfrController found");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}