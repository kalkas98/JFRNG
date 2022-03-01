package prototype;

/*
 * Deprecated
 */
public enum JfrEvent {
	THREAD_START("jdk.ThreadStart"),
	SOCKET_WRITE("jdk.SocketWrite"),
	SOCKET_READ("jdk.SocketRead"),
	GARBAGE_COLLECTION("jdk.GarbageCollection"),
	FILE_READ("jdk.FileRead"),
	FILE_WRITE("jdk.FileWrite"),
	OBJECT_ALLOCATION_IN_NEW_TLAB("jdk.ObjectAllocationInNewTLAB"),
	OBJECT_ALLOCATION_OUTSIDE_TLAB("jdk.ObjectAllocationOutsideTLAB"),
	JAVA_MONITOR_ENTER("jdk.JavaMonitorEnter"),
	JAVA_MONITOR_INFLATE("jdk.JavaMonitorInflate"),
	JAVA_MONITOR_WAIT("jdk.JavaMonitorWait");
	private String eventString;
	
	JfrEvent(String eventString) {
		this.eventString =  eventString;
	}
	
	public String getEventString() {
		return eventString;
	}
}
