package be.machteldenphilip;
import java.io.*;

public class BeledigingsBestandLezer {
	public BeledigingsLijst leesCsvBestand(String aNaam) {
		BeledigingsLijst beledigingsLijst = new BeledigingsLijst();
		beledigingsLijst.setLijstNaam(aNaam);
		try {
			int lineNr = 0;
			File aFile = new File(aNaam+".csv");
			BufferedReader aBr = new BufferedReader(new FileReader("data/"+aFile));
			String aLine = "";
			while(aLine != null) {
				aLine = aBr.readLine();
				if(aLine != null) {
					String[] lineParts = aLine.split(";", -1);
					if(lineParts.length == 1) {
						Belediging belediging = new Belediging();
						belediging.setTekst(lineParts[0]);
						beledigingsLijst.voegBeledigingToe(belediging);
					}
					else System.out.println("Aantal attributen <> 1 op " + lineNr);
					lineNr++;
				}
			}
			aBr.close();
		}
		catch(Exception e) { 
			System.out.println("foutje: " + e.getMessage()); 
			Belediging belediging1 = new Belediging();
			Belediging belediging2 = new Belediging();
			belediging1.setTekst("Ge zijt een HOER!");
			belediging2.setTekst("EEN VUILE HOER!");
			beledigingsLijst.voegBeledigingToe(belediging1);
			beledigingsLijst.voegBeledigingToe(belediging2);
		}
		return beledigingsLijst;
	}
}
