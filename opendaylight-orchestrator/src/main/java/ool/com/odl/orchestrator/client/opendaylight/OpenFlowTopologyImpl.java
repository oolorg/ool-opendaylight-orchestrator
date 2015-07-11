package ool.com.odl.orchestrator.client.opendaylight;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class OpenFlowTopologyImpl implements OpenFlowTopology {
	
	private WebResource resource = null;
	private Client client = null;
	private String ipAddress = "";
	private String port = "8080";
	private String userName = "admin";
	private String password = "admin";
	
	public OpenFlowTopologyImpl(String ipAddress, String port) {
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	@Override
	public void setAuthInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	public String getTopology() {
		this.client = Client.create();
		this.client.addFilter(new HTTPBasicAuthFilter(this.userName, this.password));
		String url = "http://" + this.ipAddress + ":" + this.port + Definition.TOPOLOGY_SERVICE_PATH;
		
		this.resource = client.resource(url);
		Builder resBuilder = this.resource.type(MediaType.APPLICATION_JSON);
		ClientResponse res = resBuilder.get(ClientResponse.class);
		
		return res.getEntity(String.class);
	}

}
