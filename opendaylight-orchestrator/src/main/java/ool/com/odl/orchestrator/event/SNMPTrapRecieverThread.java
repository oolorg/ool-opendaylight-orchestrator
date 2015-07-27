package ool.com.odl.orchestrator.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.PDUv1;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;

import ool.com.odl.orchestrator.client.opendaylight.Snmp4sdn;
import ool.com.odl.orchestrator.client.opendaylight.Snmp4sdnImpl;
import ool.com.odl.orchestrator.util.Config;
import ool.com.odl.orchestrator.util.ConfigImpl;

public class SNMPTrapRecieverThread implements CommandResponder {
	
	private static final Logger logger = Logger.getLogger(SNMPTrapRecieverThread.class);
	
	private final String hpSwitchOID = "1.3.6.1.4.1.11.2.3.7.11.88";
	private final int genericTrap_linkdown = 2;
	private final int genericTrap_linkup = 3;
	private final int specificTrap = 0;
	private Config conf = new ConfigImpl();
	
	public SNMPTrapRecieverThread() {
	}
 
	public void processPdu(CommandResponderEvent commandResponderEvent) {
		PDUv1 pdu = (PDUv1) commandResponderEvent.getPDU();
		OID oid = pdu.getEnterprise();
		Vector variableBindings = pdu.getVariableBindings();
		
		if (hpSwitchOID.equalsIgnoreCase(oid.toString())) {
			if (pdu.getGenericTrap() == genericTrap_linkdown && pdu.getSpecificTrap() == specificTrap) {
				for (int i = 0; i < variableBindings.size(); i++) {
					VariableBinding variableBinding = (VariableBinding)variableBindings.get(i);
					if (logger.isInfoEnabled()) {
						logger.info(String.format("detect SNMP Trap - IPADDRESS=%s, OID=%s, IF=%s", 
								commandResponderEvent.getPeerAddress(), oid.toString(), variableBinding.getVariable()));
					}
					Snmp4sdn client = new Snmp4sdnImpl(
							conf.getString("ipAddress"), "8080",
							conf.getString("username"), conf.getString("password")
							);
					String nodeId = conf.getString("node");
					int ret = client.deleteVLAN(nodeId, 20);
					List<Integer> portList = new ArrayList<Integer>();
					portList.add(2);
					portList.add(3);
					portList.add(4);
					ret = client.setUntagVLANPorts(nodeId, 10, portList);
				}
			}
		}
	}
}
