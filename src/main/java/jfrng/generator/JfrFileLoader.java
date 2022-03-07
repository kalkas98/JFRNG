package jfrng.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/**
 * Util class for loading the jfr event file
 * 
 */
public class JfrFileLoader
{
	public static final String EVENT_FILE  = "openjdk-17.json";
	public InputStream getStream() throws FileNotFoundException
	{
		URL url = getClass().getResource(EVENT_FILE);
	    File initialFile = new File(url.getPath());
	    InputStream jsonStream = new FileInputStream(initialFile);
	    return jsonStream;
	    
	}
}
