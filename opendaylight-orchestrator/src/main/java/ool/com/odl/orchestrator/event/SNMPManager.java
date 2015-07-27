package ool.com.odl.orchestrator.event;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class SNMPManager implements ServletContextListener {
	
	private static final Logger logger = Logger.getLogger(SNMPManager.class);

	private void start() {
		SNMPTrapReciever snmpTrapReciver = new SNMPTrapReciever(1);
		try {
			snmpTrapReciver.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
        Runtime.getRuntime().addShutdownHook(new SNMPTrapRecieverShutdownThread(snmpTrapReciver));
        */
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if (logger.isInfoEnabled()) {
			logger.info(String.format("SNMPTrapRecieverThread - Start"));
		}
		start();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (logger.isInfoEnabled()) {
			logger.info(String.format("SNMPTrapRecieverThread - End"));
		}
	}
}
