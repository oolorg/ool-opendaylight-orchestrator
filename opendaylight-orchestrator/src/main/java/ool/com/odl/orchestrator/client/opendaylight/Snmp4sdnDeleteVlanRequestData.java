package ool.com.odl.orchestrator.client.opendaylight;

import com.google.gson.annotations.SerializedName;

public class Snmp4sdnDeleteVlanRequestData {
	
	Input input;

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
	public class Input {
		@SerializedName("node-id")
		private String nodeId;
		@SerializedName("vlan-id")
		private int vlanid;

		public String getNodeId() {
			return nodeId;
		}

		public void setNodeId(String nodeId) {
			this.nodeId = nodeId;
		}

		public int getVlanid() {
			return vlanid;
		}

		public void setVlanid(int vlanid) {
			this.vlanid = vlanid;
		}
		
	}

}
