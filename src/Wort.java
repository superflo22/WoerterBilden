public abstract class Wort {

	String aWort;
	int aStatus;

	Wort() {
	}

	void stzeStausAufNie() {
	};

	String gibWort() {
		return aWort;
	}

	boolean pruefeLoesung(String Eingabe) {
		System.out.println("Eingabe:" + Eingabe);
		System.out.println("aWort:" + aWort);

		if (Eingabe.equals(aWort)) {
			System.out.println("Wort richtig");
			return true;
		} else {
			System.out.println("Wort falsch");
			return false;
		}
	}

	abstract String gibBuchstaben();
}
