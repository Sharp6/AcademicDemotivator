package be.machteldenphilip;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.ServletActionContext;

public class AcademicDemotivatorServletContextListener implements
		ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletConcextListener destroyed.");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Initializing RMI registry.");
		try {
			ServletContext ctx = ServletActionContext.getServletContext();
			ctx.setAttribute("testAttr", "testerke");
			
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			TeleBeledigingsLijst teleBeledigingen = (TeleBeledigingsLijst) registry.lookup("TeleBeledigingen");
			ctx.setAttribute("TeleBeledigingen", teleBeledigingen);
		} catch (Exception e) {
			System.out.println("Foutje in contextListener.");
		}
	}
}
