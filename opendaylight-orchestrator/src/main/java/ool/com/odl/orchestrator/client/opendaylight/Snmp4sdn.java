package ool.com.odl.orchestrator.client.opendaylight;

import java.util.List;

public interface Snmp4sdn {
	
	public void setAuthInfo(String userName, String password);
	
	public int deleteVLAN(String node, int vlanId);
	
	public int setUntagVLANPorts(String node, int vlanId, List<Integer> portList);

}
