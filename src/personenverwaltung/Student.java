package personenverwaltung;

import java.io.Serializable;

/**
 * Diese Klasse bildet einen Studenten ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
class Student extends Person implements Serializable{
	private static final long serialVersionUID = 7138562806035852454L;
	private String matrikelNummer;
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
	public Student(String vorName, String nachName, String strasse, 
	               int hausNummer, String ort, String plz) {
		super(vorName,nachName,strasse,hausNummer,ort,plz);
		erzeugeMatrikelNummer();
	}
	
	/**
	 * Erzeugt die Matrikelnummer.
	 * @since 1.0.0
	 */
	private void erzeugeMatrikelNummer() {
		this.matrikelNummer = getName().getVorName().substring(0,1) +
							  getName().getNachName().substring(0, 1) +
							  getAdresse().getOrt().substring(0,1);
	}
	
	/**
	 * Liefert die Matrikelnummer.
	 * @return die Matrikelnummer.
	 * @since 1.0.0
	 */
	protected String getMatrikelNummer() {
		return matrikelNummer;
	}
	
	/**
	 * Lässt den Studenten an der Vorlesung teilnehmen.
	 * @param vorlesung Die uebergebene Vorlesung.
	 * @since 1.0.0
	 */
	protected void nimmtAnVorlesungTeil(Vorlesung vorlesung) {
		this.vorlesung = vorlesung;		
		vorlesung.fuegeStudentHinzu(this);
	}
	
	/**
	 * Liefert das Vorlesungskuerzel.
	 * @return das Vorlesungskuerzel.
	 * @since 1.0.0
	 */
	protected String getVorlesungsKuerzel() {
		return vorlesung.getVorlesungsKuerzel();
	}
	
	/**
	 * Diese Methode setzt die Daten der Vorlesung
	 * @param note Die uebergebene Note
	 * @since 1.0.0
	 */
	protected void setGeladeneNote(double note) {
		this.vorlesung.setNote(note);
	}
	
	/**
	 * Liefert den Namen der Vorlesung.
	 * @return den Namen der Vorlesung.
	 * @since 1.0.0
	 */
	protected String getVorlesungsName() {
		return vorlesung.getVorlesungsName();
	}
	
	
	protected void setVorlesung(Vorlesung vorlesung) {
		this.vorlesung = vorlesung;
	}
	
	/**
	 * Liefert die Daten des Objektes.
	 * @return die Daten des Objektes.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		String ausgabe = "";
		ausgabe += "Matrikelnummer: "+ getMatrikelNummer() + "\n" +
				super.toString() + "\n";
		
		if(this.vorlesung != null) {
			ausgabe += "Nimmt an Vorlesung \n" + vorlesung.toString() + "\nteil.";
		}
		return ausgabe;
	}
	
	/**
	 * Vergleicht zwei Objekte.
	 * @param Das zu vergleichende Objekt.
	 * @return true, Objekte sind gleich.
	 * 		   false, Objekte sind ungleich.
	 * @since 1.0.0
	 */
	public boolean equals(Object object) {
		if(object == null) {
			throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
		} else if(!(object instanceof Student)) {
			return false;
		} else {
			Student s = (Student)object;
			boolean isGleich = super.equals(object);
			return (s.getMatrikelNummer().equals(this.getMatrikelNummer()) && isGleich);
		}
	}	
}