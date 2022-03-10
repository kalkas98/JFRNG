package jfrng.recording;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.jfr.Configuration;
import jfrng.model.event.FileRead;
import jfrng.model.event.FileWrite;
import jfrng.model.event.ObjectAllocationInNewTLAB;
import jfrng.model.event.ObjectAllocationOutsideTLAB;
import jfrng.model.event.SocketRead;
import jfrng.model.event.SocketWrite;

public class RecordingConfig
{
	private List<String> enabledEvents;
	private List<RecordingProfile> profiles;
	private Configuration jfrConfig;
	private boolean shouldRecordToDisk;
	private boolean remoteRecordingEnabled;
	private Path diskRecordingPath;
	private List<String> remoteUrls;

	public RecordingConfig() throws Exception
	{

	}

	public RecordingConfig(String[] enabledEvents) throws Exception
	{
		this.enabledEvents = new ArrayList<String>(Arrays.asList(enabledEvents));
		this.remoteUrls = new ArrayList<String>();
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

	/**
	 * Get the assigned Java flight Recorder configuration 
	 */
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

	public boolean isRemoteRecordingEnabled()
	{
		return remoteRecordingEnabled;
	}

	public void setRemoteRecordingEnabled(boolean remoteRecordingEnabled)
	{
		this.remoteRecordingEnabled = remoteRecordingEnabled;
	}

	public List<String> getRemoteUrls()
	{
		return remoteUrls;
	}

	public void addRemoteUrl(String remoteUrl)
	{
		this.remoteUrls.add(remoteUrl);
	}

}
