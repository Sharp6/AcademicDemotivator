package be.machteldenphilip;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class HelloAction implements Action {
	
	private TeleBeledigingsLijst teleBeledigingen;
	private String belediging;
	
	private String testStr;
	

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public String execute() throws Exception {
		ServletContext ctx = ServletActionContext.getServletContext();
		
		this.testStr = (String) ctx.getAttribute("testAttr");
		
		setTeleBeledigingen((TeleBeledigingsLijst) ctx.getAttribute("TeleBeledigingen"));
		if(teleBeledigingen != null) {
			belediging = teleBeledigingen.geefRandomBelediging();
		} else {
			belediging = "Fuck this shit.";
		}
		
		return SUCCESS;
	}

	public TeleBeledigingsLijst getTeleBeledigingen() {
		return teleBeledigingen;
	}

	public void setTeleBeledigingen(TeleBeledigingsLijst teleBeledigingen) {
		this.teleBeledigingen = teleBeledigingen;
	}
	
	public String getBelediging() {
		return belediging;
	}

	public void setBelediging(String belediging) {
		this.belediging = belediging;
	}

	
	
}
