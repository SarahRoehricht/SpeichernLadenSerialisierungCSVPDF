import interfaces.iDozent;
import interfaces.iSpeichernLadenSerialisiert;
import interfaces.iStudent;
import personenverwaltung.PersonenVerwaltung;

/**
 * Diese Klasse bildet die Testklasse fuer das Programm ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class TestPersonenVerwaltungSerialisiert {
	/**
	 * Main - Methode.
	 * @param args Die uebergebenen Argumente.
	 * @since 1.0.0
	 */
	public static void main(String[] args) {
		iDozent dozent;
		iStudent student;
		iSpeichernLadenSerialisiert ser;
		PersonenVerwaltung pV = new PersonenVerwaltung();
		dozent = pV; student = pV; ser = pV;
		dozent.erstelleDozenten("Frank", "Dopatka", "Musterstrasse", 1, "Musterort", "12345");
		dozent.erstelleVorlesung("Informatik 2");
		System.out.println(dozent);		
		ser.speichernSerialisiert("Serialisierung");
	}
}