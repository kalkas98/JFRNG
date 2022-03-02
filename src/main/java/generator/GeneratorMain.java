package generator;

import java.io.FileNotFoundException;

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
