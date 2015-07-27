package ool.com.odl.orchestrator.event;

import java.io.IOException;

import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;

public class SNMPTrapReciever {

    private Snmp snmp = null;
    private ThreadPool threadPool = null;
    private int threadSize = -1;
    
    public SNMPTrapReciever(int threadSize) {
    	this.threadSize = threadSize;
    }

    public void init() throws IOException {
    	this.threadPool = ThreadPool.create("Trap", this.threadSize);
    	TransportMapping transport = new DefaultUdpTransportMapping((UdpAddress)GenericAddress.parse("udp:0.0.0.0/162"));
    	this.snmp = new Snmp(
    		new MultiThreadedMessageDispatcher(this.threadPool, new MessageDispatcherImpl()),transport);
        this.snmp.getMessageDispatcher().addMessageProcessingModel(new MPv1());         // SNMPv1(RFC1157)
        this.snmp.getMessageDispatcher().addMessageProcessingModel(new MPv2c());        // SNMPv2c(RFC1901)
//		this.snmp.getMessageDispatcher().addMessageProcessingModel(new MPv3()); // SNMPv3(RFC3410)
        this.snmp.listen();
        SNMPTrapRecieverThread snmpServerThread = new SNMPTrapRecieverThread();
        this.snmp.addCommandResponder(snmpServerThread);
    }

    public void destroy() throws IOException {
    	if (this.snmp != null) {
    		this.snmp.close();
    		this.snmp = null;
    	}
    	if (this.threadPool != null) {
    		// (Stops all threads in this thread pool gracefully. This method will not return until all threads have been terminated and joined successfully.)
    		this.threadPool.stop();
    		this.threadPool = null;
    	}
    }
}

