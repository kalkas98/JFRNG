package generator;

public class JfrField
{


	public JfrField(String name, String type, String event)
	{
		this.name = name;
		this.type = type;
		this.event = event;
	}

	public JfrField(String name)
	{
		this.name = name;
	}

	private String type;
	private String name;
	private String event;


	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}
	
	public String getEvent()
	{
		return event;
	}
}
