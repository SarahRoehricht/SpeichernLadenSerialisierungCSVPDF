package interfaces;

import personenverwaltung.PersonenVerwaltung;

/**
 * Dieses Interface beinhaltet die Methoden zum Speichern der CSV.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iSpeichernLadenCSV {
	/**
	 * Diese Methode speichert die Daten in eine CSV.
	 * @param dateiName Der uebergebene Dateiname.
	 * @since 1.0.0
	 */
	public void speichernCSV(String dateiName);
	
	/**
	 * Diese Methode laedt die Objekte aus der CSV.
	 * @param dateiName Der uebergebene Dateiname.
	 * @since 1.0.0
	 */
	public PersonenVerwaltung ladecsv(String dateiName);
	
}
