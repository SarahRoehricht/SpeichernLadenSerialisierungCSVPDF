package personenverwaltung;

import java.io.Serializable;

import exceptions.UngueltigeEingabeException;

/**
 * Diese Klasse bildet den Dozenten ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
class Dozent extends Person implements Serializable {
	private static final long serialVersionUID = 8724534235798992853L;
	private Vorlesung vorlesung;
	
	/**
	 * Erzeugt ein Student - Objekt mit den uebergebenen Parametern.
	 * @param vorName Der uebergebene Vorname.
	 * @param nachName Der uebergebene Nachname.
	 * @param strasse Die uebergebeneStrasse.
	 * @param hausNummer Die uebergebene Hausnummer.
	 * @param ort Der uebergebene Ort.
	 * @param plz Die uebergebene Postleitzahl.
	 * @since 1.0.0
	 */
	protected Dozent(String vorName, String nachName, String strasse, 
                  int hausNummer, String ort, String plz) {
		super(vorName, nachName, strasse, hausNummer, ort, plz);
	}
	
	/**
	 * Setzt die zu haltende Vorlesung.
	 * @param vorlesung Die uebergebene Vorlesung.
	 * @since 1.0.0
	 */
	protected void haeltVorlesung(Vorlesung vorlesung) {
		this.vorlesung = vorlesung;
		vorlesung.haltenderDozent(this);
	}
	
	/**
	 * Diese Methode traget die Note ein.
	 * @param note Die ubergebene Note
	 * @since 1.0.0
	 */
	protected void trageNoteEin(double note) {
		if(note < 1 || note > 5) {
			throw new UngueltigeEingabeException("Bitte geben Sie eine Note zwischen 1 und 5 ein");
		} else {
			this.vorlesung.setNote(note);
		}
	}	
	
	/**
	 * Liefert das Vorlesungs - Objekt.
	 * @return das Vorlesungs - Objekt.
	 * @since 1.0.0
	 */
	protected Vorlesung getVorlesung() {
		return vorlesung;
	}
	
	/**
	 * Liefert die Daten des Objektes.
	 * @return die Daten des Objektes.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		return super.toString();
	}	
	
	/**
	 * Vergleicht zwei Objekte.
	 * @param object Das zu vergleichende Objekt.
	 * @return true, Objekte sind gleich.
	 * 		   false, Objekte sind ungleich.
	 * @since 1.0.0
	 */
	public boolean equals(Object object) {
		if(object == null) {
			throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
		} else if(!(object instanceof Dozent)) {
			return false;
		} else {
			return super.equals(object);
		}
	}
}