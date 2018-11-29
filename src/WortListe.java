
public class WortListe {
	Wort[] dasWort = new Wort[2];
	int GewaehltesWort;
	
	WortListe(){
		
	}
	
	String auswaehlenWort(){
		GewaehltesWort=0;
		
		return dasWort[GewaehltesWort].gibBuchstaben();
	}
	
	String gibAufgabe(){
		String dieBuchstaben="";
		
		dieBuchstaben = dasWort[GewaehltesWort].gibBuchstaben();
		
		
		return dieBuchstaben;
	}
}
