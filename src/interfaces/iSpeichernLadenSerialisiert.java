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
}