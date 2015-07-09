package ool.com.odl.orchestrator.service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

@Component
public class DeviceServiceImpl implements DeviceService {
	private static final Logger logger = Logger.getLogger(DeviceServiceImpl.class);

	@Inject
	//DeviceBusiness deviceBiz;
	Injector injector;

	@Override
	public Response createDevice(String newDeviceInfoJson) {
		this.injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				//bind(DeviceBusiness.class).to(DeviceBusinessImpl.class);
			}
		});
		DeviceServiceImpl main = injector.getInstance(DeviceServiceImpl.class);
		//String resDeviceBiz = main.deviceBiz.createDevice(newDeviceInfoJson);

		//return Response.ok(resDeviceBiz).type(MediaType.APPLICATION_JSON_TYPE).build();
		return Response.ok().type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Override
	public Response deleteDevice(String deviceName) {
		this.injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				//bind(DeviceBusiness.class).to(DeviceBusinessImpl.class);
			}
		});
		DeviceServiceImpl main = injector.getInstance(DeviceServiceImpl.class);
		//String resDeviceBiz = main.deviceBiz.deleteDevice(deviceName);
		
		//return Response.ok(resDeviceBiz).type(MediaType.APPLICATION_JSON_TYPE).build();
		return Response.ok().type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Override
	public Response getDevice(String deviceName) {
		this.injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				//bind(DeviceBusiness.class).to(DeviceBusinessImpl.class);
			}
		});
		DeviceServiceImpl main = injector.getInstance(DeviceServiceImpl.class);
		//String resDeviceBiz = main.deviceBiz.readDevice(deviceName);

		//return Response.ok(resDeviceBiz).type(MediaType.APPLICATION_JSON_TYPE).build();
		return Response.ok("{a:b}").type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Override
	public Response getDeviceList() {
		this.injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				//bind(DeviceBusiness.class).to(DeviceBusinessImpl.class);
			}
		});
		DeviceServiceImpl main = injector.getInstance(DeviceServiceImpl.class);
		//String resDeviceBiz = main.deviceBiz.readDeviceList();
		
		//return Response.ok(resDeviceBiz).type(MediaType.APPLICATION_JSON_TYPE).build();
		return Response.ok().type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Override
	public Response createPort(String deviceName, String portInfo) {
		this.injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				//bind(DeviceBusiness.class).to(DeviceBusinessImpl.class);
			}
		});
		DeviceServiceImpl main = this.injector.getInstance(DeviceServiceImpl.class);
		//String resDeviceBiz = main.deviceBiz.createPort(deviceName, newPortInfoJson);

		//return Response.ok(resDeviceBiz).type(MediaType.APPLICATION_JSON_TYPE).build();
		return Response.ok().type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Override
	public Response deletePort(String deviceName, String portName) {
		this.injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				//bind(DeviceBusiness.class).to(DeviceBusinessImpl.class);
			}
		});
		DeviceServiceImpl main = this.injector.getInstance(DeviceServiceImpl.class);
		//String resDeviceBiz = main.deviceBiz.deletePort(deviceName, portName);

		//return Response.ok(resDeviceBiz).type(MediaType.APPLICATION_JSON_TYPE).build();
		return Response.ok().type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}
