package jfrng.recording;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

import jdk.jfr.consumer.RecordedClass;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordedFrame;
import jdk.jfr.consumer.RecordedMethod;
import jfrng.model.event.FileRead;
import jfrng.model.event.FileWrite;
import jfrng.model.event.GarbageCollection;
import jfrng.model.event.ObjectAllocationInNewTLAB;
import jfrng.model.event.ObjectAllocationOutsideTLAB;
import jfrng.model.event.SocketRead;
import jfrng.model.event.SocketWrite;
import jfrng.model.event.ThreadStart;
import jfrng.model.type.StringJfrType;
import jfrng.model.type.ThreadJfrType;
import jfrng.model.type.doubleJfrType;
import jfrng.model.type.intJfrType;
import jfrng.model.type.longJfrType;

/*
 * Class for user functionality that controls the recording
 */
public class JfrController
{
	private EventRecorder recorder;

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
