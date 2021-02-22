package no.hvl.dat109.objects;


/**
 * Klasse for å definere en adresse.
 * 
 * @author Bjørnar, Nicolai 
 **/
public class Adresse {
	
	private String gateadresse;
	private int postnr;
	private String poststed;
	
	public Adresse(String gateadresse, int postnr, String poststed) {
		super();
		this.gateadresse = gateadresse;
		this.postnr = postnr;
		this.poststed = poststed;
	}

	public String getGateadresse() {
		return gateadresse;
	}

	public int getPostnr() {
		return postnr;
	}

	public String getPoststed() {
		return poststed;
	}
}
