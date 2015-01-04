package be.machteldenphilip;
import java.util.ArrayList;
import java.util.Random;

public class BeledigingsLijst {
	private String lijstNaam;
	private ArrayList<Belediging> beledigingen;
	
	public BeledigingsLijst() {
		this.lijstNaam = "";
		beledigingen = new ArrayList<Belediging>();
		
	}

	public String getLijstNaam() {
		return lijstNaam;
	}

	public void setLijstNaam(String lijstNaam) {
		this.lijstNaam = lijstNaam;
	}

	public ArrayList<Belediging> getBeledigingen() {
		return beledigingen;
	}

	public void setBeledigingen(ArrayList<Belediging> beledigingen) {
		this.beledigingen = beledigingen;
	}
	
	public void voegBeledigingToe(Belediging belediging) {
		this.beledigingen.add(belediging);
	}
	
	public void voegBeledigingenToe(BeledigingsLijst beledigingsLijst) {
		this.beledigingen.addAll(beledigingsLijst.getBeledigingen());
	}
	
	public Belediging geefRandomBelediging() {
		return beledigingen.get(new Random().nextInt(beledigingen.size()));
	}
	
	public String geefOverzicht() {
		String overzicht = "";
		for(Belediging belediging: beledigingen) {
			overzicht = overzicht + belediging.getTekst() +"\n";
		}
		return overzicht;
	}

}
