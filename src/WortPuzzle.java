public class WortPuzzle extends Wort {

	WortPuzzle(String wort) {
		super.setaWort(wort);
	}

	String gibBuchstaben() {
		char[] characters = super.gibWort().toCharArray();
		String out;
		for (int i = 0; i < characters.length; i++) {
			int randomIndex = (int) (Math.random() * characters.length);
			char temp = characters[i];
			characters[i] = characters[randomIndex];
			characters[randomIndex] = temp;
		}
		out = String.valueOf(characters);
		return out;
	}
}
