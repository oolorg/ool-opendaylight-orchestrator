package ool.com.odl.orchestrator.client.opendaylight;

public final class OpenFlowTopologyData {
	
	private static final OpenFlowTopologyData preTopologyData = new OpenFlowTopologyData();
	private static final OpenFlowTopologyData masterTopologyData = new OpenFlowTopologyData();
	
	private OpenFlowTopologyData() {
	}
	
	public static synchronized OpenFlowTopologyData getPreTopology() {
		return preTopologyData;
	}
	
	public static synchronized OpenFlowTopologyData getMasterTopology() {
		return masterTopologyData;
	}
	
	public String data;

}
