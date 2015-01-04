package be.machteldenphilip;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class TeleBeledigingsLijstProxy extends UnicastRemoteObject implements TeleBeledigingsLijst {

	private BeledigingsLijst beledigingLijst = null;
	
	public TeleBeledigingsLijstProxy(BeledigingsLijst beledigingsLijst) throws RemoteException {
		this.beledigingLijst = beledigingsLijst;
	}
	
	public void maakBelediging(String tekst) throws RemoteException {
		Belediging newBelediging = new Belediging();
		newBelediging.setTekst(tekst);
		beledigingLijst.voegBeledigingToe(newBelediging);
		return;
	}

	public String geefRandomBelediging() throws RemoteException {
		return beledigingLijst.geefRandomBelediging().getTekst();
	}
	

}
