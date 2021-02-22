package no.hvl.dat109.objects;

import java.util.ArrayList;
import java.util.List;

public class Bilpark {
	
	public static List<Bil> leggTilBiler1() {
		
		List<Bil> biler =new ArrayList<Bil>();
	
		Bil b1 = new Bil("SU12345", "Fiat", "Panda", "Rød", UtleiegruppeEnum.LITEN_BIL);
		biler.add(b1);
		Bil b2 = new Bil("EL34567", "Nissan", "Leaf", "Grå", UtleiegruppeEnum.MELLOMSTOR_BIL);
		biler.add(b2);
		Bil b3 = new Bil("SV99999", "Porsche", "Cayenne", "Blå", UtleiegruppeEnum.STOR_BIL);
		biler.add(b3);
		Bil b4 = new Bil("BS78934", "Volvo", "V90", "Svart", UtleiegruppeEnum.STASJONSVOGN);
		biler.add(b4);
		
		return biler;	
	}
	
	public static List<Bil> leggTilBiler2() {
		
		List<Bil> biler =new ArrayList<Bil>();
		
		Bil b1 = new Bil("SU97839", "Fiat", "Panda", "Rød", UtleiegruppeEnum.LITEN_BIL);
		biler.add(b1);
		Bil b2 = new Bil("EL32983", "Nissan", "Leaf", "Grå", UtleiegruppeEnum.MELLOMSTOR_BIL);
		biler.add(b2);
		Bil b3 = new Bil("SV23093", "Porsche", "Cayenne", "Blå", UtleiegruppeEnum.STOR_BIL);
		biler.add(b3);
		Bil b4 = new Bil("BS47579", "Volvo", "V90", "Svart", UtleiegruppeEnum.STASJONSVOGN);
		biler.add(b4);
		
		return biler;
	}

}
