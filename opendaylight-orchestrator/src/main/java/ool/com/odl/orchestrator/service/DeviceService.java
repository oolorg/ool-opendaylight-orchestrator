package ool.com.odl.orchestrator.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

@Path("/deviceService")
public interface DeviceService {

	/**
	 * Create Device
	 * @param deviceInfo String
	 * @return Http Response
	 */
	@POST
	@Path("/devices")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createDevice(@RequestBody String deviceInfo);

	/**
	 * Delete Device
	 * @param deviceName String
	 * @return Http Response
	 */
	@DELETE
	@Path("/devices/{deviceName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteDevice(@PathParam("deviceName") String deviceName);

	/**
	 * Get Device
	 * @param deviceName
	 * @return
	 */
	@GET
	@Path("/devices/{deviceName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getDevice(@PathParam("deviceName") String deviceName);

	/**
	 * Get Devices list.
	 * @return
	 */
	@GET
	@Path("/devices")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getDeviceList();

	/**
	 * Create Port
	 * @param deviceName String
	 * @param portInfo String
	 * @return Http Response
	 */
	@POST
	@Path("/devices/{deviceName}/ports")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createPort(@PathParam("deviceName") String deviceName, @RequestBody String portInfo);

	/**
	 * Delete Port
	 * @param deviceName String
	 * @param portName String
	 * @return Http Response
	 */
	@DELETE
	@Path("/devices/{deviceName}/ports/{portName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deletePort(@PathParam("deviceName") String deviceName, @PathParam("portName") String portName);
}
