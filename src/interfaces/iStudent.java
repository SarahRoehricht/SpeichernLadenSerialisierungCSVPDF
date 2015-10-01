package interfaces;

/**
 * Dieses Interface beinhaltet die Methoden fuer den Studenten.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iStudent {
	/**
	 * Erzeugt einen Studenten.
	 * @param vorName Der uebergebene Vorname.
	 * @param nachName Der uebergebene Nachname.
	 * @param strasse Die uebergebene Strasse.
	 * @param hausNummer Die uebergebene Hausnummer.
	 * @param ort Der uebergebene Ort.
	 * @param plz Die uebergebene Postleitzahl.
	 * @since 1.0.0
	 */
	public void erzeugeStudenten(String vorName, String nachName, String strasse,
			                     int hausNummer, String ort, String plz);
	
	/**
	 * Diese Methode laesst den Studenten an der Vorlesung teilnehmen.
	 * @param nameVorlesung Der uebergebene Vorlesungsname.
	 * @since 1.0.0
	 */
	public void nehmeAnVorlesungTeil(String nameVorlesung);
}