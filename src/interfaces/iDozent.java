package interfaces;
/**
 * Dieses Interface beinhaltet die Methoden die fuer den Dozenten wichtig sind.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iDozent {
	/**
	 * Erzeugt einen Dozenten.
	 * @param vorName Der uebergebene Vorname.
	 * @param nachName Der uebergebene Nachname.
	 * @param strasse Die uebergebene Strasse.
	 * @param hausNummer Die uebergebene Hausnummer.
	 * @param ort Der uebergebene Ort.
	 * @param plz Die uebergebene Postleitzahl.
	 * @since 1.0.0
	 */
	public void erstelleDozenten(String vorName, String nachName, String strasse,
			                     int hausNummer, String ort, String plz);
	
	/**
	 * Diese Methode erzeugt eine Vorlesung.
	 * @param nameVorlesung Die ubergebene Vorlesung
	 * @since 1.0.0
	 */
	public void erstelleVorlesung(String nameVorlesung);
	
	/**
	 * Diese Methode traegt die Note ein.
	 * @param note Die uebergebene Note.
	 * @since 1.0.0
	 */
	public void trageNoteEin(double note);
}