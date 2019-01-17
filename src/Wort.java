public abstract class Wort {

	private String aWort;
	private int aStatus;

	Wort() {
		aStatus = 0;
	}

	abstract String gibBuchstaben();

	boolean pruefeLoesung(String Eingabe) {
		System.out.println("Eingabe:" + Eingabe);
		System.out.println("aWort:" + aWort);

		if (Eingabe.equals(aWort)) {
			aStatus = 1;
			System.out.println("Wort richtig");
			return true;
		} else {
			aStatus = -1;
			System.out.println("Wort falsch");
			return false;
		}
	}

	void setzeStatus(int Status) {
		aStatus = Status;
	}

	String gibWort() {
		return aWort;
	}

	int gibStatus() {
		return aStatus;
	}

	void setzeStatusAufNie() {
		aStatus = 0;
	}

	void setaWort(String aWort) {
		this.aWort = aWort;
	}
}
