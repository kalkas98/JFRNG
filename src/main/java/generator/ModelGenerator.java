package generator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;

public class ModelGenerator
{

	public static final String DIR_PATH = ".target/generatedClasses";
	private File buildDir;

	public ModelGenerator()
	{
		buildDir = new File(DIR_PATH);
		buildDir.mkdirs();
	}

	public void parseJfrEvents(InputStream jsonString)
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
		JsonArray eventArray = jsonObject.get("events").getAsJsonArray();
		eventArray.forEach(elem -> {
			generateModel(elem.getAsJsonObject());
		});

	}

	public void generateModel(JsonObject eventObj)
	{
		String eventName = eventObj.getAsJsonPrimitive("name").getAsString();
		JsonArray attributeArray = eventObj.getAsJsonArray("attributes");

		JCodeModel cm = new JCodeModel();
		JPackage jp = cm._package("model");

		JDefinedClass dc;
		try
		{

			dc = jp._class(eventName);
			// For each attribute in the event
			for (JsonElement jsonElem : attributeArray)
			{
				JsonObject jsonObj = jsonElem.getAsJsonObject();
				String type = jsonObj.get("type").getAsString();
				String attributeName = jsonObj.get("name").toString().replace("\"", "");
				String upperCaseName = toUppercaseWithUnderScore(attributeName);
				JType fieldType = cm.parseType("JfrField");

				dc.field(JMod.PUBLIC | JMod.FINAL | JMod.STATIC, fieldType, upperCaseName,
						JExpr._new(fieldType).arg(attributeName).arg(type));
			}

			cm.build(buildDir);
		}
		catch (JClassAlreadyExistsException | ClassNotFoundException | IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private String toUppercaseWithUnderScore(String str)
	{
		if (str.length() < 1)
			return "";
		StringBuilder strBuffer = new StringBuilder();

		strBuffer.append(str.charAt(0));
		for (int i = 1; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (Character.isUpperCase(c))
			{
				strBuffer.append('_');
			}
			strBuffer.append(c);
		}
		return strBuffer.toString().toUpperCase();
	}

}
