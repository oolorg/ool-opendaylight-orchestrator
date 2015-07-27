package ool.com.odl.orchestrator.event;

import java.io.IOException;

public class SNMPTrapRecieverShutdownThread extends Thread{
	
    private SNMPTrapReciever snmpTrapReciever = null;

    public SNMPTrapRecieverShutdownThread(SNMPTrapReciever snmpTrapReciever) {
            this.snmpTrapReciever = snmpTrapReciever;
    }

    public void run() {
    	try {
    		this.snmpTrapReciever.destroy();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
