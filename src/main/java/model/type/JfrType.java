package model.type;

public abstract class JfrType
{
	private String attribute;
	private String event;

	public JfrType(String attribute, String event)
	{
		this.attribute = attribute;
		this.event = event;
	}

	public String getAttribute()
	{
		return attribute;
	}
	
	public String getEvent()
	{
		return event;
	}

}
