public class WortMitLücke extends Wort {

	WortMitLücke(String wort) {
		
		aWort = wort;
	}

	String gibBuchstaben() {
		String Lücke = "";

		Lücke = machLücke();

		return Lücke;
	}

	String machLücke() {
		// Todo

		return aWort;
	}

}
