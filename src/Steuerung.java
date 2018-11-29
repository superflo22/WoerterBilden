
public class Steuerung {

	Spieler []spieler = new Spieler[2];
	int aZustand, aktiverSpieler;
	
	
	Steuerung(){
		
	}

	void gedruecktStart(String name1,String name2, int Modi){
		spieler[0] = new Spieler(name1);
		spieler[1] = new Spieler(name2);
		
		aZustand = Modi;
		
	}
	void Spielroutine() {
		
	}
	
	void zugFertig(String Antwort) {
		
	}
}
