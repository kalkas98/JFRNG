package prototype;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class JfrListener implements IInvokedMethodListener
{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		
		RecordingConfig rc;
		Method m = method.getTestMethod().getConstructorOrMethod().getMethod();
		
		if (m.isAnnotationPresent(RecordJfrEvents.class))
		{
			String[] enabledEvents = m.getAnnotation(RecordJfrEvents.class).value();

			try
			{
				rc = new RecordingConfig(enabledEvents);
				if (m.isAnnotationPresent(RecordWithProfile.class) || m.isAnnotationPresent(RecordingProfiles.class))
				{
					List<RecordWithProfile> profiles = Arrays.asList(m.getAnnotationsByType(RecordWithProfile.class));
					for (RecordWithProfile profile : profiles) {
						rc.EnableProfile(profile.value());
					}
				}
				if(m.isAnnotationPresent(DumpJfrToDisk.class))
				{
					System.out.println("Here");
					rc.setPath(m.getAnnotation(DumpJfrToDisk.class).value());
					rc.setRecordToDisk(true);
				}
				MetricProvider provider = getRecorderInstance(method);
				EventRecorder recorder = new EventRecorder(rc);
				provider.setRecorder(recorder);
				recorder.startRecording();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		IInvokedMethodListener.super.beforeInvocation(method, testResult);
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		Method m = method.getTestMethod().getConstructorOrMethod().getMethod();
		if (m.isAnnotationPresent(RecordJfrEvents.class))
		{
			MetricProvider provider = getRecorderInstance(method);
			if(provider.isRecording())
			{
				provider.stopRecording();				
			}
		}
		IInvokedMethodListener.super.afterInvocation(method, testResult);
	}

	private MetricProvider getRecorderInstance(IInvokedMethod m)
	{
		Object obj = m.getTestMethod().getInstance();
		try
		{
			Field f = obj.getClass().getField("provider");
			return (MetricProvider) f.get(obj);
		}
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}