package personenverwaltung;

import interfaces.iDozent;
import interfaces.iStudent;

/**
 * Diese Klasse bildet die Personenverwaltung ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class PersonenVerwaltung implements iDozent, iStudent{
	private Student student;
	private Dozent dozent;
	private Vorlesung vorlesung;
		
	@Override
	public void erstelleDozenten(String vorName, String nachName, String strasse, int hausNummer, String ort,String plz) {
		this.dozent = new Dozent(vorName, nachName, strasse, hausNummer, ort, plz);
	}

	@Override
	public void erstelleVorlesung(String nameVorlesung) {
		this.vorlesung = new Vorlesung(nameVorlesung);
		this.vorlesung.haltenderDozent(dozent);
	}

	@Override
	public void trageNoteEin(double note) {
		vorlesung.setNote(note);
	}

	@Override
	public void erzeugeStudenten(String vorName, String nachName, String strasse, int hausNummer, String ort,String plz) {
		this.student = new Student(vorName, nachName, strasse, hausNummer, ort, plz);
	}

	@Override
	public void nehmeAnVorlesungTeil(String nameVorlesung) {	
		student.nimmtAnVorlesungTeil(vorlesung);
	}
}