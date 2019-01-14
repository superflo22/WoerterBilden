import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class WortListe {
	
	Wort[] alleWoerter;
	
	ArrayList woerter = new ArrayList();
	String wort;
	int GewaehltesWort;

	
	WortListe(int SpielZustand) {
		try {
				FileReader fr = new FileReader("src/woerter.txt");
				BufferedReader br = new BufferedReader(fr);
		
				while((wort = br.readLine()) != null) {
					woerter.add(wort);
					System.out.println(wort);
				}
				
				br.close();
				fr.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		GewaehltesWort =0;
		
		
		alleWoerter = new Wort[woerter.size()];
		for(int i = 0; i<woerter.size();i++){
			if(SpielZustand==1)
				alleWoerter [i]= new WortMitLücke((String) woerter.get(i));
			else
				alleWoerter [i]= new WortPuzzle((String) woerter.get(i));
		}

	}

	String auswaehlenWort() {
		GewaehltesWort = 0;

		return alleWoerter[GewaehltesWort].gibBuchstaben();
	}

	String gibAufgabe() {
		GewaehltesWort++;
		
		wort = alleWoerter[GewaehltesWort].gibBuchstaben();
		
		return wort;
	}
}
