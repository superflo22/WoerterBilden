public class Spieler {
	private String aName;
	private int aPunkte;

	Spieler(String name) {
		aName = name;
	}

	String gibName() {
		return aName;
	}

	int gibPunkte() {
		return aPunkte;
	}

	void addPunkte(int Punkte) {
		aPunkte= aPunkte+Punkte;
	}
}
