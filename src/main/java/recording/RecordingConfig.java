package recording;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.jfr.Configuration;
import model.event.FileRead;
import model.event.FileWrite;
import model.event.ObjectAllocationInNewTLAB;
import model.event.ObjectAllocationOutsideTLAB;
import model.event.SocketRead;
import model.event.SocketWrite;

public class RecordingConfig
{
	private List<String> enabledEvents;
	private List<RecordingProfile> profiles;
	private Configuration jfrConfig;
	private boolean shouldRecordToDisk;
	private Path diskRecordingPath;

	public RecordingConfig() throws Exception
	{

	}

	public RecordingConfig(String[] enabledEvents) throws Exception
	{
		this.enabledEvents = new ArrayList<String>(Arrays.asList(enabledEvents));
	}

	public void EnableProfile(RecordingProfile profile) throws Exception
	{
		switch (profile)
		{
		case MEMORY:
			enabledEvents.add(ObjectAllocationInNewTLAB.EVENT);
			enabledEvents.add(ObjectAllocationOutsideTLAB.EVENT);
			break;
		case FILE_IO:
			enabledEvents.add(FileRead.EVENT);
			enabledEvents.add(FileWrite.EVENT);
			break;
		case SOCKET_IO:
			enabledEvents.add(SocketWrite.EVENT);
			enabledEvents.add(SocketRead.EVENT);
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

	public List<String> getEnabledEvents()
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
