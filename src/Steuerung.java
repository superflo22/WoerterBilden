public class Steuerung {

	private GUI gui;

	private Spieler[] spieler = new Spieler[2];
	private WortListe wordlist;
	private int tries, aktiverSpieler;

	Steuerung(GUI gui) {
		this.gui = gui;
	}

	public void gedruecktStart(String name, String name2) {
		spieler[0] = new Spieler(name);
		System.out.println(name);
		spieler[1] = new Spieler(name2);
		System.out.println(name2);

		if (gui.gibSpielTyp() == 0) {
			gui.anzeigenMeldung("Spieltyp auswählen!");
		} else {
			wordlist = new WortListe(gui.gibSpielTyp());

			stelleAufgabe();
		}
	}

	public void gedruecktFertig(String Antwort) {
		if (!Antwort.isBlank())
			tries++;
		System.out.println(tries);

		if (wordlist.alleWoerter[wordlist.GewaehltesWort].pruefeLoesung(Antwort)) {
			if (tries < 2) {
				spieler[aktiverSpieler].addPunkte(5);
				gui.anzeigenMeldung("Prima, das ist richtig! (5 Punkte)");
				tries = 0;
			}
			if (tries == 2) {
				spieler[aktiverSpieler].addPunkte(1);
				gui.anzeigenMeldung("Gut, das ist jetzt richtig! (1 Punkt)");
				tries = 0;
			}

			wordlist.alleWoerter[wordlist.GewaehltesWort].setzeStatus(1);
		} else {
			if (tries < 2) {
				gui.anzeigenMeldung("Falsch, aber du hast noch eine Chance!");
			}
			if (tries == 2) {
				gui.anzeigenMeldung("Leider auch falasch. → Spielerwechsel");
				wechsleSpieler();
			}

			wordlist.alleWoerter[wordlist.GewaehltesWort].setzeStatus(-1);
		}
	}

	public void gedruecktOK() {
		gui.loescheLoeseung();
		if (tries != 1)
			stelleAufgabe();
	}

	private void stelleAufgabe() {
		wordlist.auswaehlenWort();
		gui.anzeigenAufgabe(wordlist.gibAufgabe());
		gui.anzeigenAmZug(spieler[aktiverSpieler].gibName());
		gui.anzeigenPunkte(spieler[0].gibPunkte(), spieler[1].gibPunkte());
	}

	private void wechsleSpieler() {
		if (aktiverSpieler == 1) {
			aktiverSpieler = 0;
		} else
			aktiverSpieler++;
		tries = 0;
	}
}
