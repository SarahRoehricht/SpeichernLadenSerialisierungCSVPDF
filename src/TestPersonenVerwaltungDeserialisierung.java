import interfaces.iDozent;
import interfaces.iStudent;
import personenverwaltung.PersonenVerwaltung;

public class TestPersonenVerwaltungDeserialisierung {
	/**
	 * Main - Methode
	 * @param args Die uebergebenen Argumente
	 * @since 1.0.0
	 */
	public static void main(String[] args) {
		PersonenVerwaltung pv = PersonenVerwaltung.ladeSerialisiert("Serialisierung");
		iStudent student = pv;
		iDozent dozent = pv;
		student.erzeugeStudenten("Alfred", "Loran", "Geht euch n scheiss an", 10, "Reutlingen", "72762");
		System.out.println(student);
		student.nehmeAnVorlesungTeil("Informatik 2");
		System.out.println(student);
		dozent.trageNoteEin(1.3);
		System.out.println(dozent);
	}
}