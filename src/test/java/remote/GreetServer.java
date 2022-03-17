package remote;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class GreetServer implements IGreeter
{
	public final static int JMX_PORT = 1919;
	public final static String JMX_HOST = "localhost";
	public final static String URL = "service:jmx:rmi:///jndi/rmi://" + JMX_HOST + ":" + JMX_PORT + "/jmxrmi";
	public final static String BINDING_NAME = "greeter";

	public GreetServer()
	{
	}

	public String Greet()
	{
		Thread t1 = new Thread();
		t1.start(); // Start a thread to trigger a jfr event
		return "Greetings Traveler!";
	}

	private static void echo(String str)
	{
		System.out.println(str);
	}

	public static void main(String[] args) throws Exception
	{

		initRMIServer();
		echo("bound remote object to registry...");

		initJMXConnectorServer();
		echo("JMX connector server started...");
		
		for (;;)
		{
			Thread t1 = new Thread();
			t1.start();
			Thread.sleep(500);
			t1.stop();
		}

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
		GreetServer s1 = new GreetServer();
		IGreeter remoteObj = (IGreeter) UnicastRemoteObject.exportObject(s1, 0);
		Registry registry = LocateRegistry.getRegistry();
		registry.bind(BINDING_NAME, remoteObj);
	}
}
