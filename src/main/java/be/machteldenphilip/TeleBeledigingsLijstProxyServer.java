package be.machteldenphilip;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TeleBeledigingsLijstProxyServer {

	public static void main(String[] args) {
		try {
			BeledigingsLijst initial = (new BeledigingsBestandLezer()).leesCsvBestand("test");
			TeleBeledigingsLijstProxy beledigingsLijstProxy = new TeleBeledigingsLijstProxy(initial);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("TeleBeledigingsLijst", beledigingsLijstProxy);
		} catch(Exception e)
		{
			System.out.println("Beledigingslijst proxy server: " + e.getMessage());
		}
	}
}
