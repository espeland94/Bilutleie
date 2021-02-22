package no.hvl.dat109.controller;

import java.util.Scanner;

import no.hvl.dat109.objects.Adresse;
import no.hvl.dat109.objects.Bilpark;
import no.hvl.dat109.objects.Kontor;
import no.hvl.dat109.objects.Selskap;

public class Klient {
	
	private static Selskap easyCar = new Selskap("EasyCar", new Adresse("Tulleveien 1", 4308, "Sandnes"), "92822779");
	private static Kontor bergen = new Kontor("Bergen", new Adresse("Tulleveien 2", 5063, "Bergen"), easyCar);
	private static Kontor sandnes = new Kontor("Sandnes", new Adresse("Tulleveien 1", 4308, "Sandnes"), easyCar);

	public static void main(String[] args) {

		bergen.setBiler(Bilpark.leggTilBiler1());
		sandnes.setBiler(Bilpark.leggTilBiler2());
		
		easyCar.leggTilKontor(sandnes);
		easyCar.leggTilKontor(bergen);
		
	
		valgMeny();

	}
	
	public static void valgMeny() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Hei og velkommen til EasyCar. Meny: ");
		System.out.println("1. Reservasjon");
		System.out.println("2. Utlevering av bil");
		System.out.println("3. Innlevering av bil");
		System.out.println("4. Avslutt");
		System.out.println("\nSkriv inn tallet for ønsket valg:\n");

		int valg = sc.nextInt();
		
		switch (valg) {
			case 1: 
				ReserverBil.reserverBil(easyCar);
				break;
			case 2:
				UtleieBil.leiUt(easyCar);
				break;
			case 3:
				InnleveringBil.leverInn(easyCar);
				break;
			case 4:
				System.out.println("\nProgrammet er avsluttet.");
			default:
				System.out.println("Noe gikk galt.");
		}
		
	}

}
