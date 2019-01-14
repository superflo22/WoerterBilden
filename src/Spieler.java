public class Spieler {
	String aName;
	int aPunkte;
	
	Spieler(String name){
		aName = name;
	}
	String getName() {
		return aName;
	}
	
	int getPunkte() {
		return aPunkte;
	}
	void gibPunkte() {
		aPunkte++;
	}
	
}
