package generator;

public abstract class JfrType
{
	private String name;
	private String event;

	public JfrType(String name, String event)
	{
		this.name = name;
		this.event = event;
	}

	public String getName()
	{
		return name;
	}
	
	public String getEvent()
	{
		return event;
	}

}
