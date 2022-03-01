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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
		JsonArray typeArray = jsonObject.get("types").getAsJsonArray();
		typeArray.forEach(elem -> {
			generateType(elem.getAsJsonObject());
		});

	}

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
			dc._extends(jClassExtends);
			
			JMethod constructor = dc.constructor(JMod.PUBLIC);
			JVar nameParam = constructor.param(0, String.class, "name"); //Add param
			JVar eventParam = constructor.param(0, String.class, "event"); //Add param
			constructor.body().invoke("super").arg(nameParam).arg(eventParam) ; //Invoke parent constructor

			
			cm.build(buildDir);
		}
		catch (JClassAlreadyExistsException | IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
