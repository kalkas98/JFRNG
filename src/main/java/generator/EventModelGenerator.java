package generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;

public class EventModelGenerator
{

	public static final String DIR_PATH = "target/generatedModels";
	private File buildDir;

	public EventModelGenerator()
	{
		buildDir = new File(DIR_PATH);
		buildDir.mkdirs();
	}

	/**
	 * Takes an input stream for JSON file describing jfr events and generates model classes for them
	 * Such JSON files are found here: https://github.com/BestSolution-at/jfr-doc
	 * @param jsonString
	 */
	public void generateEventModels(InputStream jsonString)
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

		JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject(); //Get Json file as object
		JsonArray eventArray = jsonObject.get("events").getAsJsonArray();
		//For each event in the event array, generate its model class
		eventArray.forEach(event -> {
			generateModel(event.getAsJsonObject()); 
		});

	}
	
	
	/**
	 * Takes a JsonObject representing a JFR-event and generates its model
	 * @param eventObj
	 */
	public void generateModel(JsonObject eventObj)
	{
		String eventName = eventObj.getAsJsonPrimitive("name").getAsString();
		JsonArray attributeArray = eventObj.getAsJsonArray("attributes");
		String jdkEventName = "jdk.".concat(eventName);
		JExpression nameExpr = JExpr.lit(jdkEventName);

		JCodeModel cm = new JCodeModel();
		JPackage jp = cm._package("model");
		JDefinedClass dc;
		try
		{

			dc = jp._class(eventName);
			//Create a field containing the event name
			dc.field(JMod.PUBLIC | JMod.STATIC | JMod.FINAL, String.class, "EVENT", nameExpr);
			// For each attribute in the event
			for (JsonElement attribute : attributeArray)
			{
				JsonObject attributeObj = attribute.getAsJsonObject();
				String attributeName = attributeObj.get("name").toString().replace("\"", "");
				String upperCaseName = camelCaseToMacroCase(attributeName);

				String type = attributeObj.get("type").getAsString();
				String typeClassName = type.concat("JfrType");
				JClass typeClass = cm.ref("model.type.".concat(typeClassName));
				JType fieldType = cm.parseType(typeClass.fullName());
				//Create a field representing the attribute
				dc.field(JMod.PUBLIC | JMod.FINAL | JMod.STATIC, fieldType, upperCaseName,
						JExpr._new(fieldType).arg(attributeName).arg(dc.fields().get("EVENT")));
			}

			cm.build(buildDir);
		}
		catch (JClassAlreadyExistsException | ClassNotFoundException | IOException e1)
		{
			e1.printStackTrace();
		}

	}

	/**
	 * 
	 * e.g: definingClassLoader --> DEFINING_CLASS_LOADER
	 */
	private String camelCaseToMacroCase(String str)
	{
		if (str.length() <= 1)
			return str.toUpperCase();
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
