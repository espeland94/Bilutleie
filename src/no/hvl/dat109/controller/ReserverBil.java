package no.hvl.dat109.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.objects.Adresse;
import no.hvl.dat109.objects.Bil;
import no.hvl.dat109.objects.Kontor;
import no.hvl.dat109.objects.Kunde;
import no.hvl.dat109.objects.Reservasjon;
import no.hvl.dat109.objects.Selskap;

/**
 * 
 * @author Bjørnar, Nicolai 
 **/

public class ReserverBil {
	
	public static void reserverBil(Selskap selskap) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
		
		System.out.println("Skriv inn utleiekontor: ");
		String utleiekontor = sc.nextLine();
		
		System.out.println("Skriv inn ønsket returkontor: ");
		String returkontor = sc.nextLine();
		
		System.out.println("Skriv inn dato du ønsker å leie fra. (dd/MM/yyyy)");
		String stringdato = sc.nextLine();
		
		dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dato = LocalDate.parse(stringdato, dtf);
		
		System.out.println("Skriv inn ønsket klokkeslett for utleie. (HH:mm)");
		String klokke = sc.nextLine();
		dtf = DateTimeFormatter.ofPattern("hh:mm");
		LocalTime tidspunkt = LocalTime.parse(klokke);
		
		
		System.out.println("Skriv inn hvor mange dager du vil leie bilen: ");
		int dager = sc.nextInt();
		
		
		List<Kontor> alleKontorer = selskap.getKontorer();
		System.out.println(alleKontorer);
		
		Kontor utleieplass = alleKontorer.stream()
				.filter(k -> utleiekontor.equals(k.getNavn()))
				.findAny()
				.orElse(null);
		
		Kontor returplass = alleKontorer.stream()
				.filter(k -> returkontor.equals(k.getNavn()))
				.findAny()
				.orElse(null);
		
		System.out.println(utleieplass.getNavn());
		List<Bil> alleBiler = utleieplass.getBiler();
		
		List<Bil> tilgjBiler =  alleBiler.stream()
				.filter(b -> b.getLedig() == true)
				.collect(Collectors.toList());
		
		System.out.println("Tilgjengelige biler: ");
		tilgjBiler.stream().forEach(System.out :: println);
		
		System.out.println("Skriv inn regnr for ønsket bil: ");
		sc.nextLine();
		String regnr = sc.nextLine();
		
		
		Bil bil = tilgjBiler.stream()
				.filter(b -> regnr.equals(b.getRegnr()))
				.findAny()
				.orElse(null);
		
		if(bil == null) {
			System.out.println("Finnes ikke en bil med dette registreringsnummeret");
			sc.close();
			return;
		}
		
		System.out.println("Skriv inn fornavn: ");
		String fnavn = sc.nextLine();
		
		System.out.println("Skriv inn etternavn: ");
		String enavn = sc.nextLine();
		
		System.out.println("Skriv inn tlf: ");
		int tlf = sc.nextInt();
		
		System.out.println("Skriv inn gateadresse: ");
		sc.nextLine();
		String gateadresse = sc.nextLine();
		
		System.out.println("Skriv inn postnr: ");
		int postnr = sc.nextInt();
		
		System.out.println("Skriv inn poststed: ");
		sc.nextLine();
		String poststed = sc.nextLine();
		
		
		
		System.out.println("Reservasjon fullført!");
		System.out.println();
		
		
		Kunde k1 = new Kunde(fnavn, enavn, tlf, new Adresse(gateadresse, postnr, poststed));
		Reservasjon reservasjon = new Reservasjon(bil, dato, tidspunkt, dager, utleieplass, returplass, k1);
		selskap.leggTilReservasjon(reservasjon);
		

		Klient.valgMeny();
		
	}

}
