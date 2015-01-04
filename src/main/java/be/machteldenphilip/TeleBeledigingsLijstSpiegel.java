package be.machteldenphilip;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TeleBeledigingsLijstSpiegel {

	public static void main(String[] args) {
		try {
			System.out.println("Hallo vanuit TeleBeledigingsLijstSpiegel.");
			
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			TeleBeledigingsLijst teleBeledigingsLijst = (TeleBeledigingsLijst) registry.lookup("TeleBeledigingsLijst");
			teleBeledigingsLijst.maakBelediging("A moeder is een hoer!");
			
			System.out.println(teleBeledigingsLijst.geefRandomBelediging());
		} catch(Exception e) {
			System.out.println("TeleBeledigingsLijstSpiegel fout: " + e.getMessage());
		}
	}
}
