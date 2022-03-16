package jfrng.generator;

import java.io.FileNotFoundException;
/**
 * Main class for generating event and types classes from a JSON file
 *
 */
public class GeneratorMain
{
	
	public static void main(String[] args) throws FileNotFoundException
	{

	    JfrFileLoader loader = new JfrFileLoader();
	    
	    TypeGenerator tgen = new TypeGenerator();
	    tgen.generateJfrTypes(loader.getStream());
	    
		EventModelGenerator gen = new EventModelGenerator();
		gen.generateEventModels(loader.getStream());

	}

}
