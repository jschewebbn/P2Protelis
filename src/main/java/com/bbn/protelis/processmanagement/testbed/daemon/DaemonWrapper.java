package com.bbn.protelis.processmanagement.testbed.daemon;

import java.io.IOException;
import java.util.Set;

import org.protelis.lang.datatype.DeviceUID;
import org.protelis.vm.ExecutionEnvironment;

import com.bbn.protelis.processmanagement.daemon.ProcessStatus;
import com.bbn.protelis.processmanagement.testbed.Scenario;

public interface DaemonWrapper {
	/**
	 * Every DaemonWrapper should be instantiable with a no-argument constructor from a JSON object; initialize then move from that initial state into an live, executing daemon
	 * @throws IOException 
	 */
	public void initialize(Scenario scenario) throws IOException;
	
	/**
	 * @return Status of the daemon
	 */
	public ProcessStatus getDaemonStatus();
	/**
	 * @return Status of the process being managed by the daemon
	 */
	public ProcessStatus getProcessStatus();
	
	/**
	 * Calling shutdown signals the wrapped daemon to stop executing and shut down
	 */
	public void shutdown();
	
	public Object getValue();
	public int getRound();
	public ExecutionEnvironment getEnvironment();
	public long getUID();
	public void signalProcess(ProcessStatus init);
	public Set<DeviceUID> getPhysicalNeighbors();
	public Set<DeviceUID> getLogicalNeighbors();
}
