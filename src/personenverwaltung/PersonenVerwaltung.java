package personenverwaltung;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import hilfsklassen.PDF;
import hilfsklassen.Serialisieren;
import interfaces.iDozent;
import interfaces.iSpeichernLadenSerialisiert;
import interfaces.iSpeichernPDF;
import interfaces.iStudent;

/**
 * Diese Klasse bildet die Personenverwaltung ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class PersonenVerwaltung implements iDozent, iStudent, iSpeichernLadenSerialisiert, iSpeichernPDF, Serializable{
	private static final long serialVersionUID = 1789253660935452408L;
	private Student student;
	private Dozent dozent;
	private Vorlesung vorlesung;
		
	@Override
	public void erstelleDozenten(String vorName, String nachName, String strasse, int hausNummer, String ort,String plz) {
		this.dozent = new Dozent(vorName, nachName, strasse, hausNummer, ort, plz);
	}

	@Override
	public void erstelleVorlesung(String nameVorlesung) {
		this.vorlesung = new Vorlesung(nameVorlesung);
		this.vorlesung.haltenderDozent(dozent);
	}

	@Override
	public void trageNoteEin(double note) {
		vorlesung.setNote(note);
	}

	@Override
	public void erzeugeStudenten(String vorName, String nachName, String strasse, int hausNummer, String ort,String plz) {
		this.student = new Student(vorName, nachName, strasse, hausNummer, ort, plz);
	}

	@Override
	public void nehmeAnVorlesungTeil(String nameVorlesung) {	
		student.nimmtAnVorlesungTeil(vorlesung);
	}
	

	@Override
	public void speichernSerialisiert(String dateiName) {
		Serialisieren serialisieren = new Serialisieren();
		Properties properties = new Properties();
		properties.setProperty("Dateiname", dateiName + ".ser");
		properties.setProperty("Modus", "s");
		try {
			serialisieren.oeffnen(properties);
			serialisieren.schreiben(this);
		} catch(IOException fehler) {
			System.err.println(fehler.getMessage());
		} finally {
			try {
				serialisieren.schliessen(null);
			} catch(IOException fehler) {
				System.err.println(fehler.getMessage());
			}
		}
	}
	
	/**
	 * Laedt die das Objekt in der Serialisierten Datei.
	 * @param dateiName Der uebergebene Dateiname.
	 * @return das deserialisierte Objekt.
	 * @since 1.0.0
	 */
	public static PersonenVerwaltung ladeSerialisiert(String dateiName) {
		Serialisieren serialisieren = new Serialisieren();
		Properties properties = new Properties();
		properties.setProperty("Dateiname", dateiName + ".ser");
		properties.setProperty("Modus", "l");
		try {
			serialisieren.oeffnen(properties);
			PersonenVerwaltung pV = (PersonenVerwaltung)serialisieren.lesen();
			return pV;
		} catch(IOException fehler) {
			System.err.println(fehler.getMessage());
		} finally {
			try {
				serialisieren.schliessen(null);
			} catch(IOException fehler) {
				System.err.println(fehler.getMessage());	
			}
		}
		return null;
	}
	
	@Override
	public void speichernPDF(String dateiName) {
		PDF pdf = new PDF();
		Properties properties = new Properties();
		properties.setProperty("dateiName", dateiName + ".pdf");
		try {
			pdf.oeffnen(properties);
			pdf.schreiben(this.toString());
		} catch(IOException fehler) {
			System.err.println(fehler.getMessage());
		} finally {
			try {
				pdf.schliessen(null);
			} catch(IOException fehler) {
				System.err.println(fehler.getMessage());
			}
		}
	}
		
	/**
	 * Liefert die Daten des Objektes.
	 * @return die Daten des Objektes.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		String ausgabe = "";
		if(this.student != null) {
			ausgabe += this.student.toString();
		} else {
			ausgabe += "Noch keine Daten vorhanden!";
		}
		return ausgabe;
	}
}