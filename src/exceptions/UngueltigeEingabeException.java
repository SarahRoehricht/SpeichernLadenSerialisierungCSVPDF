package exceptions;

/**
 * Diese Klasse bildet eine Excepion ab, 
 * die geworfen wird sobald eine ungueltige 
 * Eingabe erfolgt.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class UngueltigeEingabeException extends IllegalArgumentException {
	private static final long serialVersionUID = -8047091955973158885L;
	
	/**
	 * Erzeugt ein UngueltigeEingabeException - Objekt.
	 * @since 1.0.0
	 */
	public UngueltigeEingabeException() {}
	
	/**
	 * Erzeugt ein UngueltigeEingabeException - Objekt.
	 * @param nachricht Die uebergebene Nachricht.
	 * @since 1.0.0
	 */
	public UngueltigeEingabeException(String nachricht) {
		super(nachricht);
	}
}