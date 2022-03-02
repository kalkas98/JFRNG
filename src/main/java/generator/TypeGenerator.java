package generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JVar;

import model.type.JfrField;

public class TypeGenerator
{
	public static final String DIR_PATH = "target/generatedTypes";
	private File buildDir;
	
	public TypeGenerator()
	{
		buildDir = new File(DIR_PATH);
		buildDir.mkdirs();
	}

	
	/**
	 * Takes an input stream for a JSON file describing jfr types and generates model classes for them
	 * Such JSON files are found here: https://github.com/BestSolution-at/jfr-doc
	 * @param jsonString
	 */
	public void generateJfrTypes(InputStream jsonString)
	{
		JsonReader reader = null;
		try
		{
			reader = new JsonReader(new InputStreamReader(jsonString, "UTF-8"));
			reader.setLenient(true);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
		JsonArray typeArray = jsonObject.get("types").getAsJsonArray();
		typeArray.forEach(elem -> {
			generateType(elem.getAsJsonObject());
		});

	}

	/**
	 * Takes a JsonObject representing a JFR-type and generates its model
	 * @param typeObj
	 */
	public void generateType(JsonObject typeObj)
	{
		String typeName = typeObj.getAsJsonPrimitive("name").getAsString();
		typeName = typeName.concat("JfrType");

		JCodeModel cm = new JCodeModel();
		JPackage jp = cm._package("model.type");

		JDefinedClass dc;
		try
		{

			dc = jp._class(typeName);
			JClass jClassExtends = cm.ref(JfrField.class);
			dc._extends(jClassExtends); //Extend JfrField
			
			JMethod constructor = dc.constructor(JMod.PUBLIC); //Add constructor
			JVar nameParam = constructor.param(0, String.class, "name"); //Add name param
			JVar eventParam = constructor.param(0, String.class, "event"); //Add event param
			constructor.body().invoke("super").arg(nameParam).arg(eventParam) ; //Invoke parent constructor

			
			cm.build(buildDir);
		}
		catch (JClassAlreadyExistsException | IOException e1)
		{
			e1.printStackTrace();
		}

	}
}
