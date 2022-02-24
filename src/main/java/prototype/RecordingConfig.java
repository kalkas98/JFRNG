package prototype;

import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.jfr.Configuration;

public class RecordingConfig
{
	private List<JfrEvent> enabledEvents;
	private List<RecordingProfile> profiles;
	private Configuration jfrConfig;
	private boolean shouldRecordToDisk;
	private Path diskRecordingPath;

	public RecordingConfig() throws Exception
	{

	}

	public RecordingConfig(JfrEvent[] enabledEvents) throws Exception
	{
		this.enabledEvents = new ArrayList<JfrEvent>(Arrays.asList(enabledEvents));
	}

	public void EnableProfile(RecordingProfile profile) throws Exception
	{
		switch (profile)
		{
		case MEMORY:
			enabledEvents.add(JfrEvent.OBJECT_ALLOCATION_IN_NEW_TLAB);
			enabledEvents.add(JfrEvent.OBJECT_ALLOCATION_OUTSIDE_TLAB);
			break;
		case FILE_IO:
			enabledEvents.add(JfrEvent.FILE_READ);
			enabledEvents.add(JfrEvent.FILE_WRITE);
			break;
		case SOCKET_IO:
			enabledEvents.add(JfrEvent.SOCKET_WRITE);
			enabledEvents.add(JfrEvent.SOCKET_READ);
			break;
		case DEFAULT:
			this.jfrConfig = Configuration.getConfiguration("default");
			break;
		case PROFILE:
			this.jfrConfig = Configuration.getConfiguration("profile");
			break;
		default:
			break;
		}
	}

	public List<JfrEvent> getEnabledEvents()
	{
		return enabledEvents;
	}

	public Configuration getJfrConfig()
	{
		return jfrConfig;
	}

	public List<RecordingProfile> getProfiles()
	{
		return profiles;
	}
	
	public boolean recordToDisk()
	{
		return shouldRecordToDisk;
	}
	
	public void setRecordToDisk(boolean shouldRecordToDisk)
	{
		this.shouldRecordToDisk = shouldRecordToDisk;
	}
	
	public void setPath(String path)
	{
		diskRecordingPath = Path.of(path);
	}
	
	public Path getPath()
	{
		return diskRecordingPath;
	}

}
