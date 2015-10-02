package interfaces;

import personenverwaltung.PersonenVerwaltung;

/**
 * Dieses Interface beinhaltet die Methden zum serialisiertem 
 * Speichern und Laden.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iSpeichernLadenSerialisiert {
	/**
	 * Diese Methode speichert das Programm serialisiert ab.
	 * @param dateiName Der uebergebene Dateiname.
	 * @since 1.0.0
	 */
	public void speichernSerialisiert(String dateiName);
	
	/**
	 * Diese Methode laedt die PersonenVerwaltungsklasse aus der Serialisierungsdatei.
	 * @param dateiName Der uebergebene Dateiname.
	 * @return das deserialisierte PersonenVerwaltungs - Objekt
	 * @since 1.0.0
	 */
	public PersonenVerwaltung ladeSerialisiert(String dateiName);
}