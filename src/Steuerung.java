public class Steuerung {

	Spieler[] spieler = new Spieler[2];
	int aZustand, aktiverSpieler;
	GUI gui;
	WortListe wordlist;

	Steuerung(GUI gui) {
		this.gui = gui;
	}

	void Spielroutine() {
		gui.updateLbL(spieler[aktiverSpieler].getName(), wordlist.gibAufgabe());
	}

	void zugFertig(String Antwort) {
		if (wordlist.alleWoerter[wordlist.GewaehltesWort].pruefeLoesung(Antwort)) {
			spieler[aktiverSpieler].gibPunkte();
		} else {
			if (aktiverSpieler == 1) {
				aktiverSpieler = 0;
			} else
				aktiverSpieler++;
		}
		Spielroutine();
	}

	public void gedruecktStart(String name, String name2, int Modi) {
		spieler[0] = new Spieler(name);
		System.out.println(name);
		spieler[1] = new Spieler(name2);
		System.out.println(name2);

		aZustand = Modi;
		System.out.println(Modi);

		wordlist = new WortListe(aZustand);
		Spielroutine();
	}
}
