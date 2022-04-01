package jfrng.recording;

import java.lang.reflect.Field;

import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;

public class JfrTestClassListener implements ITestListener
{
	@Override
	public void onStart(ITestContext context)
	{
		//A bit weird, but it's the only way to access the controller instance that I could find.
		EventRecorder recorder = new EventRecorder();
		context.setAttribute("recorder", recorder);
		//ITestListener.super.onStart(context);
	}
	
	/**
	 * Gets the JfrController instance in the test class
	 * @param method - TestNG test method
	 * @return JfrController instance of the test class
	 */
	private JfrController getControllerInstance(Object instance)
	{
		JfrController controller = null;
		boolean controllerFound = false;
		try
		{
			Field[] fields = instance.getClass().getDeclaredFields();
			String controllerTypeName = JfrController.class.getTypeName();
			for (Field field : fields)
			{
				String fieldTypeName = field.getGenericType().getTypeName();
				if(fieldTypeName.equals(controllerTypeName))
				{
					if(controllerFound)
						throw new Exception("Multiple JfrControllers found");
					controller = (JfrController) field.get(instance);
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
