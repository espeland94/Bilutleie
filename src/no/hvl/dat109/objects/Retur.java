/**
 * 
 */
package no.hvl.dat109.objects;

import java.time.LocalDate;

/**
 * @author Bjørnar, Nicolai 
 **/
public class Retur {

	private Kredittkort kredittkort;
	private LocalDate returdato;
	private String regnr;
	private int kmStand;
	
	public Retur(Kredittkort kredittkort, LocalDate returdato, String regnr, int kmStand) {
		super();
		this.kredittkort = kredittkort;
		this.returdato = returdato;
		this.regnr = regnr;
		this.kmStand = kmStand;
	}
	
}
