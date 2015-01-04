package be.machteldenphilip;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TeleBeledigingsLijst extends Remote {
	void maakBelediging(String tekst) throws RemoteException;
	String geefRandomBelediging() throws RemoteException;
}
