package jfrng.generator;

/**
 *	Make sure this file exists in the model.type when you generate the types
 *
 */
public abstract class JfrField
{
	private String attributeName;
	private String event;

	public JfrField(String attributeName, String event)
	{
		this.attributeName = attributeName;
		this.event = event;
	}

	public String name()
	{
		return attributeName;
	}
	
	public String getEvent()
	{
		return event;
	}
	

}
