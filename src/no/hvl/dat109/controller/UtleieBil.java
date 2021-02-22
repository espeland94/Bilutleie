package no.hvl.dat109.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.objects.Bil;
import no.hvl.dat109.objects.Kredittkort;
import no.hvl.dat109.objects.Kunde;
import no.hvl.dat109.objects.Reservasjon;
import no.hvl.dat109.objects.Selskap;
import no.hvl.dat109.objects.Utlevering;


/**
 * Klasse som definerer utleie for en bil
 * 
 * @author Bjørnar, Nicolai 
 **/
public class UtleieBil {
	
	/**
	 * Metode for å leie ut en bil.
	 * 
	 * @param bil
	 */
	public static void leiUt(Selskap selskap) {
		Scanner sc = new Scanner(System.in);
		
		LocalDate currDate = LocalDate.now();
		
		System.out.println("Skriv inn telefonnummer: ");
		int telefonnummer = sc.nextInt();
		
		List<Reservasjon> alleReservasjoner = selskap.getReservasjoner();
		
		Reservasjon res = alleReservasjoner.stream()
				.filter(r -> telefonnummer == r.getKunde().getTlfNr())
				.findAny()
				.orElse(null);
		
		if(res == null) {
			System.out.println("Finnes ikke en reservasjon med dette telefonnummeret");
			sc.close();
			return;
		}
		
		Kunde kunde = res.getKunde();
		
		System.out.println("Skriv inn kredittkortnummer: ");
		long kortNummer = sc.nextLong();
		
		Kredittkort kort = new Kredittkort(kortNummer);
		Boolean gyldigKort = kort.validerKort();
		
		while (!gyldigKort) {
			System.out.println("Kortnummer ikke gyldig, må ha en lengde på 16 siffer. Prøv igjen: ");
			int nyttKortNummer = sc.nextInt();
			
			kort.setKortNummer(nyttKortNummer);
			gyldigKort = kort.validerKort();
		}
		
		kunde.setKredittKort(kort);
		String regNr = res.getBil().getRegnr();
		int kmstand = res.getBil().getKmStand();
		
		Utlevering utlevering = new Utlevering(kunde.getKredittKort(), regNr, kmstand, currDate, res.getStartDato().plusDays(res.getAntallDager()));
		selskap.leggTilUtlevertBil(utlevering);
		System.out.println();
		System.out.println("Her er bilen din! :)");
		Klient.valgMeny();
		
		Klient.valgMeny();
	}
}
