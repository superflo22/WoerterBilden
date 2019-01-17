public class WortMitLücke extends Wort {

	WortMitLücke(String wort) {
		super.setaWort(wort); 
	}

	String gibBuchstaben() {
		char[] characters = super.gibWort().toCharArray();
		int luecke = (int) (Math.random() * characters.length);
		characters[luecke] = '_';
		String wort = String.valueOf(characters);
		return wort;
	}
}
