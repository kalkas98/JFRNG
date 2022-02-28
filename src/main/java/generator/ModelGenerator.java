package generator;

import java.io.File;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JType;

public class modelGenerator
{
	
	public static final String DIR_PATH = ".target/generatedClasses";
	private File buildDir;
	
	public modelGenerator()
	{
		buildDir = new File(DIR_PATH);
		buildDir.mkdirs();
	}
	

	//Tmp
	public void generateModels() throws JClassAlreadyExistsException, IOException
	{
		JCodeModel cm = new JCodeModel();
		JDefinedClass dc = cm._class("foo.Bar");
		JMethod m = dc.method(0, int.class, "foo");

		File file = new File("./target/classes");
		file.mkdirs();
		cm.build(file);
	}
	
	public void parseJfrEvents(String jsonString)
	{
		JsonObject jsonObject =  JsonParser.parseString(jsonString).getAsJsonObject();
		JsonArray eventArray = jsonObject.get("events").getAsJsonArray();
		eventArray.forEach(elem -> {
			generateModel(elem.getAsJsonObject());
		});
		
		JsonElement nameElem = jsonObject.get("name");
		JsonElement attributesElem = jsonObject.get("attributes");
		
		JsonArray arr = attributesElem.getAsJsonArray();

		
	}
	
	public void generateModel(JsonObject elem)
	{
		String name = elem.getAsJsonPrimitive("name").getAsString();
		JsonArray attributeArray = elem.getAsJsonArray("attributes");
		
		JCodeModel cm = new JCodeModel();
		JDefinedClass dc;
		try
		{
			dc = cm._class(name);
			//For each elem in attributeArray:
			for (JsonElement jsonElem : attributeArray)
			{
				JsonObject jsonObj = jsonElem.getAsJsonObject();
				String type = jsonObj.get("type").getAsString();
				String nam = jsonObj.get("name").toString(); //TODO: Convert name to uppercase with underlines separating words
				JfrField jfrField = new JfrField(name,type);
				JType fieldType = cm.parseType("JfrField");
				
				JFieldVar field = dc.field(JMod.PUBLIC | JMod.FINAL | JMod.STATIC, fieldType, jsonObj.get("name").toString(),
						JExpr._new(fieldType).arg(name).arg(type));
			}
			
			cm.build(buildDir);
		}
		catch (JClassAlreadyExistsException | ClassNotFoundException | IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

	
}
