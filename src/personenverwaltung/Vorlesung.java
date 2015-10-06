package personenverwaltung;

import java.io.Serializable;

import exceptions.UngueltigeEingabeException;

/**
 * Diese Klasse bildet eine Vorlesung ab.
 * 
 * @author Alfred Loran
 * @version 1.0.0
 */
class Vorlesung implements Serializable{
	private static final long serialVersionUID = -5805656603587345820L;
	private static int anzahlVorlesungsObjekte;
	private int vorlesungsNummer;
	private String vorlesungsKuerzel;
	private String vorlesungsName;
	private double note;
	private Student student;
	private Dozent dozent;

	/**
	 * Erzuegt ein Vorlesungs - Objekt.
	 * @param vorlesungsName Der uebergebene Vorlesungsname.
	 * @since 1.0.0
	 */
	protected Vorlesung(String vorlesungsName) {
		setVorlesungsNummer(++anzahlVorlesungsObjekte);
		setVorlesungsName(vorlesungsName);
		setVorlesungsKuerzel();
	}

	/**
	 * Liefert die Vorlesungsnummer.
	 * @return die Vorlesungsnummer.
	 * @since 1.0.0
	 */
	private int getVorlesungsNummer() {
		return vorlesungsNummer;
	}

	/**
	 * Setzt die Vorlesungsnummer.
	 * @param vorlesungsNummer Die uebergebene Nummer.
	 * @since 1.0.0
	 */
	private void setVorlesungsNummer(int vorlesungsNummer) {
		this.vorlesungsNummer = vorlesungsNummer;
	}

	/**
	 * Liefert das Kuerzel der Vorlesung.
	 * @return das Kuerzel der Vorlesung.
	 * @since 1.0.0
	 */
	protected String getVorlesungsKuerzel() {
		return vorlesungsKuerzel.toUpperCase();
	}

	/**
	 * Generiert das Kuerzel der Vorlesung.
	 * @since 1.0.0
	 */
	private void setVorlesungsKuerzel() {
		this.vorlesungsKuerzel = getVorlesungsName().substring(0,2) + "-" + getVorlesungsNummer();
	}

	/**
	 * Lieert den Vorlesungsnamen.
	 * @return den Vorlesungsnamen.
	 * @since 1.0.0
	 */
	protected String getVorlesungsName() {
		return vorlesungsName;
	}
	
	/**
	 * Setzt den Vorlesungsnamen.
	 * @param vorlesungsName Der uebergebene Name.
	 * @since 1.0.0
	 */
	private void setVorlesungsName(String vorlesungsName) {
		if(vorlesungsName == null) {
			throw new NullPointerException("Kein Vorlesungsname vorhanden!");
		} else {
			if(vorlesungsName.length() < 3) {
				throw new UngueltigeEingabeException("Geben Sie mindestens 3 Zeichen als Vorlesung ein!");
			} else {
				this.vorlesungsName = vorlesungsName;
			}
		}
	}

	/**
	 * Liefert die Note.
	 * @return die Note.
	 * @since 1.0.0
	 */
	protected double getNote() {
		return note;
	}

	/**
	 * Setzt die Note.
	 * @param note Die uebergebene Note.
	 * @since 1.0.0
	 */
	protected void setNote(double note) {
		if(note == 0) {
			this.note = 0;
		} else if(note < 0 || note > 5) {
			throw new UngueltigeEingabeException("Bitte geben Sie eine Note zwischen 1 und 5 ein!");
		} else {
			this.note = note;
		}
	}
	
	/**
	 * Diese Methode fuegt den Studenten der Vorlesung hinzu.
	 * @param student Der hinzugefügte Student.
	 * @since 1.0.0
	 */
	protected void fuegeStudentHinzu(Student student) {
		this.student = student;
	}
	
	/**
	 * Diese Methode setzt den Dozenten der die Note haelt.
	 * @param dozent Der uebergebene Dozent.
	 * @since 1.0.0
	 */
	protected void haltenderDozent(Dozent dozent) {
		this.dozent = dozent;
	}
	
	/**
	 * Diese Methode bietet die Möglichkeit die Werte direkt zu setzen.
	 * Sie soll lediglich beim laden der CSV ihre Verwendung finden.
	 * @param vorlesungsKuerzel Das uebergebene Vorlesungskuerzel.
	 * @param vorlesungsName Der uebergebene Vorlesungsname.
	 * @since 1.0.0
	 */
	protected void setVorlesung(String vorlesungsKuerzel, String vorlesungsName, Dozent dozent) {
		this.vorlesungsKuerzel = vorlesungsKuerzel;
		this.vorlesungsName = vorlesungsName;
		this.dozent = dozent;
	}
	
	/**
	 * Liefert das Dozenten - Objekt.
	 * @return das Dozenten - Objekt.
	 * @since 1.0.0
	 */
	protected Dozent getDozent(){
		return dozent;
	}

	/**
	 * Liefert das Studenten - Objekt.
	 * @return das Studenten - Objekt.
	 * @since 1.0.0
	 * @return
	 */
	protected Student getStudent() {
		return student;
	}
	
	/**
	 * Liefert die Daten des Objektes.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		return	"Gehalten von: " + dozent.toString() + "\n" +
				"Vorlesungskuerzel " + getVorlesungsKuerzel() + "\n" + 
	            "Vorlesungsname: " + getVorlesungsName() + "\n" +
	            "Note: " + getNote();
	}
	
	/**
	 * Vergleicht zwei Objekte.
	 * @param object Das zu vergleichende Objekt.
	 * @return true, Objekte sind gleich.
	 * 		   false, Objekte sind ungleich.
	 * @since 1.0.0
	 */
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			throw new NullPointerException("Kein Objekt zum vergleichen vorhanden!");
		} else if(!(object instanceof Vorlesung)) {
			return false;
		} else {
			Vorlesung v = (Vorlesung)object;
			return ((v.getVorlesungsNummer() == this.getVorlesungsNummer()) && 
					(v.getVorlesungsKuerzel().equals(this.getVorlesungsKuerzel()) &&
					(v.getVorlesungsName().equals(this.getVorlesungsName()) &&
					(v.getNote() == this.getNote()))));
		}
	}
}
