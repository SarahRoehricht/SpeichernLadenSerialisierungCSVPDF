package interfaces;

/**
 * Dieses Interface beinhaltet die Methode zum Speichern in einer PDF.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iSpeichernPDF {
	/**
	 * Diese Methode speichert die Daten in einer PDF.
	 * @param dateiName Der uebergebene Dateiname.
	 * @since 1.0.0
	 */
	public void speichernPDF(String dateiName);
}