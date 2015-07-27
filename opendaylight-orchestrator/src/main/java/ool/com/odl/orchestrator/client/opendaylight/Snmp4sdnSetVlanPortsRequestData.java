package ool.com.odl.orchestrator.client.opendaylight;

import com.google.gson.annotations.SerializedName;

public class Snmp4sdnSetVlanPortsRequestData {
	
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
		@SerializedName("untagged-port-list")
		private String untaggedPortList;
		@SerializedName("tagged-port-list")
		private String taggedPortList;

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

		public String getUntaggedPortList() {
			return untaggedPortList;
		}

		public void setUntaggedPortList(String untaggedPortList) {
			this.untaggedPortList = untaggedPortList;
		}
		
		public String getTaggedPortList() {
			return taggedPortList;
		}

		public void setTaggedPortList(String taggedPortList) {
			this.taggedPortList = taggedPortList;
		}
	}

}
