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

/**
 * Class that contains the configuration for a recording
 *
 */
public class RecordingConfig
{
	private List<String> enabledEvents;
	private List<RecordingProfile> profiles;
	
	// A predefined JFR configuration https://docs.oracle.com/en/java/javase/14/jfapi/flight-recorder-configurations.html
	private Configuration jfrConfig;
	
	private boolean recordToDiskEnabled;
	private boolean remoteRecordingEnabled;
	private boolean disableStacktrace;
	private Path diskRecordingPath;
	private List<String> remoteUrls; //List containing URLs of the remote hosts that RemoteRecordingStreams are connected to
		


	public RecordingConfig(String[] enabledEvents) throws Exception
	{
		this.enabledEvents = new ArrayList<String>(Arrays.asList(enabledEvents));
		this.remoteUrls = new ArrayList<String>();
		this.recordToDiskEnabled = false;
		this.remoteRecordingEnabled = false;
		this.disableStacktrace = false;
	}

	/**
	 * Enable a profile that enables a set of events for the recording
	 */
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
		return recordToDiskEnabled;
	}
	
	public void setRecordToDisk(boolean shouldRecordToDisk)
	{
		this.recordToDiskEnabled = shouldRecordToDisk;
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

	public boolean isStacktraceDisabled()
	{
		return disableStacktrace;
	}

	public void setStacktraceDisabled(boolean disableStacktrace)
	{
		this.disableStacktrace = disableStacktrace;
	}

}
