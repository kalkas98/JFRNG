package generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class GeneratorMain
{
	
	public static void main(String[] args) throws FileNotFoundException
	{

	    FileLoader loader = new FileLoader();
	    
	    TypeGenerator tgen = new TypeGenerator();
	    tgen.generateJfrTypes(loader.getStream());
	    
		ModelGenerator gen = new ModelGenerator();
		gen.parseJfrEvents(loader.getStream());

	}

}
