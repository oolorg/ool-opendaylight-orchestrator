package ool.com.odl.orchestrator.client.opendaylight;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Snmp4sdnImpl implements Snmp4sdn {
	
	private static final Logger logger = Logger.getLogger(Snmp4sdnImpl.class);
	
	private WebResource resource = null;
	private Client client = null;
	private String ipAddress = "";
	private String port = "8080";
	private String userName = "admin";
	private String password = "admin";
	
	public Snmp4sdnImpl(String ipAddress, String port) {
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	public Snmp4sdnImpl(String ipAddress, String port,
			String userName, String password) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	public void setAuthInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public int deleteVLAN(String node, int vlanId) {
		this.client = Client.create();
		this.client.addFilter(new HTTPBasicAuthFilter(this.userName, this.password));
		String url = "http://" + this.ipAddress + ":" + this.port + Definition.SNMP4SDN_DELETE_VLAN_PATH;
		
		Snmp4sdnDeleteVlanRequestData reqData = new Snmp4sdnDeleteVlanRequestData();
		Snmp4sdnDeleteVlanRequestData.Input input = reqData.new Input();
		input.setNodeId(node);
		input.setVlanid(vlanId);
		reqData.setInput(input);
		
		Gson gson = new Gson();
		//Type type = new TypeToken<Snmp4sdnDeleteVlanRequestData>() {}.getType();
		String body = gson.toJson(reqData);
		OpenFlowTopologyData.setMasterTopology(body);
		this.resource = client.resource(url);
		Builder resBuilder = this.resource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
		ClientResponse res = resBuilder.post(ClientResponse.class, body);
		
		//return res.getEntity(String.class);
		return 0;
	}

	@Override
	public int setUntagVLANPorts(String node, int vlanId, List<Integer> portList) {
		this.client = Client.create();
		this.client.addFilter(new HTTPBasicAuthFilter(this.userName, this.password));
		String url = "http://" + this.ipAddress + ":" + this.port + Definition.SNMP4SDN_SET_VLAN_PORTS_PATH;
		
		Snmp4sdnSetVlanPortsRequestData reqData = new Snmp4sdnSetVlanPortsRequestData();
		Snmp4sdnSetVlanPortsRequestData.Input input = reqData.new Input();
		input.setNodeId(node);
		input.setVlanid(vlanId);
		String ports = "";
		for (int i = 0; i < portList.size(); i++) {
		    ports += portList.get(i).toString();
		    if ( i < portList.size() - 1) {
		    	ports += ",";
		    }
		}
		input.setTaggedPortList("");
		input.setUntaggedPortList(ports);
		reqData.setInput(input);
		
		Gson gson = new Gson();
		String body = gson.toJson(reqData);
		if (logger.isInfoEnabled()) {
			logger.info(String.format("set port = %d, vlan_id = %d", 4, 10));
		}
		this.resource = client.resource(url);
		Builder resBuilder = this.resource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
		ClientResponse res = resBuilder.post(ClientResponse.class, body);
		
		//return res.getEntity(String.class);
		return 0;
	}

}
