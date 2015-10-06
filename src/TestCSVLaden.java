import interfaces.iDozent;
import interfaces.iSpeichernLadenCSV;
import interfaces.iStudent;
import personenverwaltung.PersonenVerwaltung;

/**
 * Diese Klasse dient als Testklasse fuer das Laden aus eienr CSV Datei.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class TestCSVLaden {

	/**
	 * Main - Methode.
	 * @param args Die uebergebenen Parameter.
	 * @since 1.0.0
	 */
	public static void main(String[] args) {
		PersonenVerwaltung personVer = new PersonenVerwaltung();
		iSpeichernLadenCSV csv = personVer;
		PersonenVerwaltung pV = csv.ladecsv("TestCSV");		
		iStudent student;
		iDozent dozent;
		student = pV;
		dozent = pV;
		System.out.println(dozent);
		student.erzeugeStudenten("Alfred", "Loran", "Geht euch n scheiss an", 10, "Reutlingen", "72762");
		System.out.println(student);
		
		student.nehmeAnVorlesungTeil("Informatik 2");
		System.out.println(student);
		dozent.trageNoteEin(1.3);
		System.out.println(dozent);		
	}
}