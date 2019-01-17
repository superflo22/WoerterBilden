import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class WortListe {

	Wort[] alleWoerter;

	ArrayList woerter = new ArrayList();
	String wort;
	int GewaehltesWort = 0;

	WortListe(int SpielZustand) {
		try {
			FileReader fr = new FileReader("src/woerter.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((wort = br.readLine()) != null) {
				woerter.add(wort);
			}

			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		alleWoerter = new Wort[woerter.size()];

		for (int i = 0; i < woerter.size(); i++) {
			if (SpielZustand == 1) {
				alleWoerter[i] = new WortMitLücke((String) woerter.get(i));
			} else if (SpielZustand == 2)
				alleWoerter[i] = new WortPuzzle((String) woerter.get(i));

			System.out.println(alleWoerter[i].gibWort());
		}
	}

	String gibAufgabe() {
		System.out.println(alleWoerter[GewaehltesWort].gibBuchstaben());

		return alleWoerter[GewaehltesWort].gibBuchstaben();
	}

	void auswaehlenWort() {
		do {
			GewaehltesWort = (int) (Math.random() * (double) woerter.size());
		} while (alleWoerter[GewaehltesWort].gibStatus() == 1);
		System.out.println(GewaehltesWort);
	}
}
