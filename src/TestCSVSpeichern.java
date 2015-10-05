import interfaces.iDozent;
import interfaces.iSpeichernLadenCSV;
import personenverwaltung.PersonenVerwaltung;

/**
 * Diese Klasse bildet die Testklasse für das CSV speichern ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class TestCSVSpeichern {
	/**
	 * Main - Methode.
	 * @param args Die uebergebenen Argumente.
	 * @since 1.0.0
	 */
	public static void main(String[] args) {
		PersonenVerwaltung pV = new PersonenVerwaltung();
		iSpeichernLadenCSV csv;
		csv = pV; 
		iDozent dozent;
		dozent = pV;
		dozent.erstelleDozenten("Frank", "Dopatka", "Musterstrasse", 1, "Musterort", "12345");
		dozent.erstelleVorlesung("Informatik 2");
		System.out.println(dozent);
		csv.speichernCSV("TestCSV");
	}
}