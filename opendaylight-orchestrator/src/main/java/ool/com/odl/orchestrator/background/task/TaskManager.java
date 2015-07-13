package ool.com.odl.orchestrator.background.task;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TimerTask;

import ool.com.odl.orchestrator.client.opendaylight.OpenFlowTopology;
import ool.com.odl.orchestrator.client.opendaylight.OpenFlowTopologyData;
import ool.com.odl.orchestrator.client.opendaylight.OpenFlowTopologyImpl;
import ool.com.odl.orchestrator.util.Config;
import ool.com.odl.orchestrator.util.ConfigImpl;

public class TaskManager extends TimerTask {
	
	private volatile boolean isFirst = true;
	
	private Config conf = null;
	private OpenFlowTopology openFlowTopology = null; 
	
	private void init() {
		conf = new ConfigImpl();
		openFlowTopology = new OpenFlowTopologyImpl(
				conf.getString("ipAddress"), conf.getString("port"),
				conf.getString("username"), conf.getString("password")); 
	}
	
	public void run() {
		if (isFirst) {
            isFirst = false;
            init();
		}
		String res = openFlowTopology.getTopology();
		OpenFlowTopologyData preTopology = OpenFlowTopologyData.getPreTopology();
		preTopology.data = res;
	}	
}
