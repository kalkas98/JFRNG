package jfrng.recording;

/*
 * Class for user functionality that controls the recording
 */
public class JfrController
{
	private EventRecorder recorder;
	public String lol; //TODO: REMOVE THIS

	public JfrController(String lol)
	{
		this.lol = lol;
	}
	
	public JfrController() {};

	public void setRecorder(EventRecorder recorder)
	{
		this.recorder = recorder;
	}

	/**
	 * Returns the result of the recording with out stopping the recording
	 * @return the result of the recording in the form of a JfrResult object
	 */
	public JfrResult getResult()
	{
		return new JfrResult(recorder.getEventList());
	}

	
	/**
	 * Stops the recording and returns the result
	 * @return The result of the recording in the form of a JfrResult object
	 */
	public JfrResult stopRecording()
	{
		recorder.stopRecording();
		return new JfrResult(recorder.getEventList());
	}

	public boolean isRecording()
	{
		return recorder.isRecording();
	}

	/**
	 * Clears previously recorded events and continues recording
	 */
	public void reset()
	{
		recorder.reset();
	}

}
