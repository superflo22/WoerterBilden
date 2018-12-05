public class WortListe {
	
	String[] Woerter = {"Haus","Maus","Feuer"};
	Wort[] alleWoerter = new Wort[20];
	int GewaehltesWort;

	
	WortListe(int SpielZustand){
		GewaehltesWort =0;
		
		
		for(int i = 0; i<Woerter.length;i++){
			if(SpielZustand==1)
				alleWoerter [i]= new WortMitLücke(Woerter[i]);
			else
				alleWoerter [i]= new WortPuzzle(Woerter[i]);
		}

	}

	String auswaehlenWort() {
		GewaehltesWort = 0;

		return alleWoerter[GewaehltesWort].gibBuchstaben();
	}

	String gibAufgabe() {
		String dieBuchstaben = "";
GewaehltesWort++;
		dieBuchstaben = alleWoerter[GewaehltesWort].gibBuchstaben();

		
		return dieBuchstaben;
	}
}
