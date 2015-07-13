package ool.com.odl.orchestrator.background.task;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TaskStarter implements ServletContextListener {

	private void start() {
        Timer timer = new Timer();
        timer.schedule(new TaskManager(), 0, 5000);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ignore) {
        }
        timer.cancel();
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		start();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
