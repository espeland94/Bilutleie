package no.hvl.dat109.objects;

import java.time.LocalDate;

/**
 * 
 * @author Bjørnar, Nicolai
 *  
 **/

public class Utlevering {

	private Kredittkort kredittkort;
	private String regnr;
	private int kmStand;
	private LocalDate utleieDato;
	private LocalDate returDato;
	
	
	public Utlevering(Kredittkort kredittkort, String regnr, int kmStand, LocalDate utleieDato, LocalDate returDato) {
		super();
		this.kredittkort = kredittkort;
		this.regnr = regnr;
		this.kmStand = kmStand;
		this.utleieDato = utleieDato;
		this.returDato = returDato;
	}
	
	public Kredittkort getKredittkort() {
		return kredittkort;
	}
}
