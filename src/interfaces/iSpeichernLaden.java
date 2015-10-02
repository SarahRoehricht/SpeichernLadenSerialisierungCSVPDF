package interfaces;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Alfred Loran
 *
 */
public interface iSpeichernLaden {
	/**
	 * Diese Methode oeffnet eine Datei.
	 * @param p Das uebegebene Properties -  Objekt
	 * @throws IOException Wird geworfen, wenn die Datei nicht geoeffnet werden kann.
	 * @since 1.0.0
	 */
	public void oeffnen(Properties p) throws IOException;
    
	/**
	 * Diese Methode schreibt in die Datei hinein.
	 * @param object Das zu schreibenede Objekt.
	 * @throws IOException Wird geworfen, wenn das Objekt nicht in die Datei geschrieben werden kann.
	 * @since 1.0.0
	 */
	public void schreiben(Object object) throws IOException;

	/**
	 * Liest den Inhalt aus einer Datei.
	 * @return Den Inhalt der Datei
	 * @throws IOException Wird geworfen, wenn der Inhalt nicht gelsen werden kann.
	 * @since 1.0.0
	 */
	public Object lesen() throws IOException;
    
	/**
	 * Schliest eine Datei.
	 * @param object Das uebergebene Objekt.
	 * @throws IOException Wird geworfen, wenn die DAtei nicht geschlossen werden kann.
	 * @since 1.0.0
	 */
	public void schliessen(Object object)throws IOException;
}
