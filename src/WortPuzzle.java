public class WortPuzzle extends Wort {

	WortPuzzle(String wort) {
		
		aWort = wort;
	}
	
	String gibBuchstaben() {
		String gemischelt="";
		
		gemischelt = mischeln();
		
		return gemischelt;
	}
	String mischeln(){
		//Todo
		
		
		return aWort;
	}
}
