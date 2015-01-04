package be.machteldenphilip;
import java.io.*;

public class BeledigingsBestandSchrijver {
	public void schrijfCsvBestand(BeledigingsLijst beledigingsLijst) {
		try {
			String outputStr = "";
			for(Belediging belediging: beledigingsLijst.getBeledigingen()) {
				System.out.println("Belediging: " + belediging.getTekst());
				outputStr += belediging.getTekst() + "\n";
			}
			File nFile = new File(beledigingsLijst.getLijstNaam() + ".csv.out");
			//if(!(nFile.exists())) {
				DataOutputStream nDos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nFile.getCanonicalPath(), true)));
				nDos.writeBytes(outputStr);
				nDos.flush();
				nDos.close();
			//} else {
			//	System.out.println("Deelnemerslijst bestand bestaat reeds.");
			//}
			
		}
		catch(Exception e) { }		
	}
}
