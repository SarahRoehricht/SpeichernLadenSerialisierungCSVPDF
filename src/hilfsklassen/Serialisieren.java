package hilfsklassen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import interfaces.iSpeichernLaden;

public class Serialisieren implements iSpeichernLaden {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	/**
	 * Oeffnet die Serialisierungsdatei.
	 * @param p Das uebergebene Properties Objekt.
	 * @throws IOException Wird geworfen, wenn die Datei nicht geoeffnet werden kann oder der
	 * 					   Modus nicht korrekt gesetzt wurde.
	 * @since 1.0.0
	 */
	@Override
	public void oeffnen(Properties p) throws IOException {
		String dateiName = p.getProperty("Dateiname");
		
		if(dateiName == null) {
			throw new IOException("Dateiname wurde nicht definiert!");
		}
		
		if("s".equals(p.getProperty("Modus"))) {
			oos =  new ObjectOutputStream(new FileOutputStream(dateiName));
		} else if("l".equals(p.getProperty("Modus"))){
			ois = new ObjectInputStream(new FileInputStream(dateiName));
		} else {
			throw new IOException("Modus wurde nicht oder falsch definiert!");
		}
	}

	/**
	 * Schreibt den Byte - Strom in die Datei.
	 * @since Das serialisierte Objekt.
	 * @throws IOException Wird geworfen, wenn das Schreiben nicht funktioniert.
	 * @since 1.0.0
	 */
	@Override
	public void schreiben(Object object) throws IOException {
		if(oos == null) {
			throw new IOException("Stream ist nicht zum Schreiben geoeffnet!");
		} else {
			oos.writeObject(object);
		}
	}

	/**
	 * Liest den Byte - Strom aus der Datei.
	 * @return Den Byte - Strom in deserialisierter Form.
	 * @since 1.0.0
	 */
	@Override
	public Object lesen() throws IOException {
		if(ois == null) {
			throw new IOException("Stream ist nicht zum Lesen geoeffnet!");
		}
		
		try {
			Object object = ois.readObject();
			return object;
		} catch(ClassNotFoundException fehler) {
			throw new IOException("Konnte nicht deserialisieren!");
		}
	}

	/**
	 * Diese Methode schliesst die Datei.
	 * @param object Das zu schliessende Objekt.
	 * @since 1.0.0
	 */
	@Override
	public void schliessen(Object object) throws IOException {
		if(ois != null) {
			ois.close();
			ois = null;
		}
		
		if(oos != null) {
			oos.close();
			oos = null;
		}		
	}
}