
public class Steuerung {

	Spieler []spieler = new Spieler[2];
	int aZustand, aktiverSpieler;
	GUI gui;
	WortListe wordlist;
	
	Steuerung(GUI gui){
		this.gui = gui;
	}

	void gedruecktStart(String name1,String name2, int Modi){
		spieler[0] = new Spieler(name1);
		spieler[1] = new Spieler(name2);
		
		aZustand = Modi;
		
	}
	void Spielroutine() {
		if(aktiverSpieler==2)aktiverSpieler=1;
		else 				aktiverSpieler++;
		
		gui.updateLbL(String.valueOf(aktiverSpieler),wordlist.gibAufgabe());
		
	}
	
	void zugFertig(String Antwort) {
		
	}

	public void gedruecktStart(String name, String name2, boolean Modi) {
		spieler[0] = new Spieler(name);
		System.out.println(name);
		spieler[1] = new Spieler(name2);
		System.out.println(name2);

		
		if(Modi)aZustand = 2;
		else 	aZustand = 1;
		
		wordlist = new WortListe(aZustand);
		Spielroutine();
	}
}
