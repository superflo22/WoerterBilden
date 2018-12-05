
public abstract class Wort {

	String aWort;
	int aStatus;
	
	Wort(){
		
		
	}
	
	void stzeStausAufNie(){};
	
	String gibWort(){
		return aWort;
	}
	
	boolean pruefeLoesung(String Eingabe){
		if(Eingabe==aWort)
			return true;
		else
			return false;
	}
	
	abstract String gibBuchstaben();
}
