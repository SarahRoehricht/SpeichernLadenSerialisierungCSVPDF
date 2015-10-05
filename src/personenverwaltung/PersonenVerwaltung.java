package personenverwaltung;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import hilfsklassen.CSV;
import hilfsklassen.PDF;
import hilfsklassen.Serialisieren;
import interfaces.iDozent;
import interfaces.iSpeichernLadenCSV;
import interfaces.iSpeichernLadenSerialisiert;
import interfaces.iSpeichernPDF;
import interfaces.iStudent;

/**
 * Diese Klasse bildet die Personenverwaltung ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class PersonenVerwaltung implements iDozent, iStudent, iSpeichernLadenSerialisiert, iSpeichernPDF, iSpeichernLadenCSV,Serializable{
	private static final long serialVersionUID = 1789253660935452408L;
	private Student student;
	private Dozent dozent;
	private Vorlesung vorlesung;
	
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
	@Override
	public void erstelleDozenten(String vorName, String nachName, String strasse, int hausNummer, String ort,String plz) {
		this.dozent = new Dozent(vorName, nachName, strasse, hausNummer, ort, plz);
	}

	/**
	 * Diese Methode erzeugt eine Vorlesung.
	 * @param nameVorlesung Die ubergebene Vorlesung
	 * @since 1.0.0
	 */
	@Override
	public void erstelleVorlesung(String nameVorlesung) {
		this.vorlesung = new Vorlesung(nameVorlesung);
		this.vorlesung.haltenderDozent(dozent);
	}

	/**
	 * Diese Methode traegt die Note ein.
	 * @param note Die uebergebene Note.
	 * @since 1.0.0
	 */
	@Override
	public void trageNoteEin(double note) {
		vorlesung.setNote(note);
	}

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
	@Override
	public void erzeugeStudenten(String vorName, String nachName, String strasse, int hausNummer, String ort,String plz) {
		this.student = new Student(vorName, nachName, strasse, hausNummer, ort, plz);
	}

	/**
	 * Diese Methode laesst den Studenten an der Vorlesung teilnehmen.
	 * @param nameVorlesung Der uebergebene Vorlesungsname.
	 * @since 1.0.0
	 */
	@Override
	public void nehmeAnVorlesungTeil(String nameVorlesung) {	
		student.nimmtAnVorlesungTeil(vorlesung);
	}
	
	/**
	 * Diese Methode speichert das Programm serialisiert ab.
	 * @param dateiName Der uebergebene Dateiname.
	 * @since 1.0.0
	 */
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
	
	/**
	 * Diese Methode speichert die Daten in einer PDF.
	 * @param dateiName Der uebergebene Dateiname.
	 * @since 1.0.0
	 */
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
	 * Diese Methode speichert die Daten in eine CSV.
	 * @param dateiName Der uebergebene Dateiname.
	 * @since 1.0.0
	 */
	@Override
	public void speichernCSV(String dateiName) {
		CSV csv = new CSV();
		Properties properties = new Properties();
		properties.setProperty("Dateiname", dateiName + ".csv");
		properties.setProperty("Modus", "s");
		
		try {
			csv.oeffnen(properties);
			String nullString = null;
			String auchNullString = "0";
			
			//Daten fuer den Dozenten
			if(this.dozent != null) {
				String dozentenNummer = "" + dozent.getPersonenNummer();
				csv.schreiben(dozentenNummer);
				String dozentVorname = "D" + dozent.getName().getVorName();
				csv.schreiben(dozentVorname);
				String dozentenNachname = "D" + dozent.getName().getNachName();
				csv.schreiben(dozentenNachname);
				String dozentenStrasse = "D" + dozent.getAdresse().getStrasse();
				csv.schreiben(dozentenStrasse);
				String dozentenHausNummer = "D" + dozent.getAdresse().getHausNummer();
				csv.schreiben(dozentenHausNummer);
				String dozentenOrt = "D" + dozent.getAdresse().getOrt();
				csv.schreiben(dozentenOrt);
				String dozentenPLZ = "D" + dozent.getAdresse().getPostLeitZahl();
				csv.schreiben(dozentenPLZ);
			} else {
				String dozentenNummer = "" + auchNullString;
				csv.schreiben(dozentenNummer);
				String dozentVorname = nullString;
				csv.schreiben(dozentVorname);
				String dozentenNachname = nullString;
				csv.schreiben(dozentenNachname);
				String dozentenStrasse = nullString;
				csv.schreiben(dozentenStrasse);
				String dozentenHausNummer = auchNullString;
				csv.schreiben(dozentenHausNummer);
				String dozentenOrt = nullString;
				csv.schreiben(dozentenOrt);
				String dozentenPLZ = nullString;
				csv.schreiben(dozentenPLZ);
			}
				
			//Daten fuer die Vorlesung
			if(this.vorlesung != null) {
				String vorlesungsKuerzel = vorlesung.getVorlesungsKuerzel();
				csv.schreiben(vorlesungsKuerzel);
				String vorlesungsName = vorlesung.getVorlesungsName();
				csv.schreiben(vorlesungsName);
			} else {
				String vorlesungsKuerzel = nullString;
				csv.schreiben(vorlesungsKuerzel);
				String vorlesungsName = nullString;
				csv.schreiben(vorlesungsName);
			}
			
			
			//Daten fuer den Studenten
			if(this.student != null) {
				String matrikelNummer = student.getMatrikelNummer();
				csv.schreiben(matrikelNummer);
				String studentVorname = "S" + student.getName().getVorName();
				csv.schreiben(studentVorname);
				String studentenNachname = "S" + student.getName().getNachName();
				csv.schreiben(studentenNachname);
				String studentenStrasse = "S" + student.getAdresse().getStrasse();
				csv.schreiben(studentenStrasse);
				String studentHausnummer = "S" + student.getAdresse().getHausNummer();
				csv.schreiben(studentHausnummer);
				String studentOrt = "S" + student.getAdresse().getOrt();
				csv.schreiben(studentOrt);
				String studentPLZ = "S" + student.getAdresse().getPostLeitZahl();
				csv.schreiben(studentPLZ);
				String studentenVorelsungKuerzel = "S" + student.getVorlesungsKuerzel();
				csv.schreiben(studentenVorelsungKuerzel);
				String studentenVorlesungName = "S" + student.getVorlesungsName();
				csv.schreiben(studentenVorlesungName);
				String note = "" + vorlesung.getNote();
				csv.schreiben(note);
			} else {
				String matrikelNummer = nullString;
				csv.schreiben(matrikelNummer);
				String studentVorname = nullString;
				csv.schreiben(studentVorname);
				String studentenNachname = nullString;
				csv.schreiben(studentenNachname);
				String studentenStrasse = nullString;
				csv.schreiben(studentenStrasse);
				String studentHausnummer = auchNullString;
				csv.schreiben(studentHausnummer);
				String studentOrt = nullString;
				csv.schreiben(studentOrt);
				String studentPLZ = nullString;
				csv.schreiben(studentPLZ);
				String studentenVorelsungKuerzel = nullString;
				csv.schreiben(studentenVorelsungKuerzel);
				String studentenVorlesungName = nullString;
				csv.schreiben(studentenVorlesungName);
				String note = auchNullString;
				csv.schreiben(note);
			}			
		} catch(IOException fehler) {
			System.err.println(fehler.getMessage());
		} finally {
			try {
				csv.schliessen(null);
			} catch(IOException fehler) {
				System.err.println(fehler.getMessage());
			}
		}
	}
	
	/**
	 * Diese Methode laedt die Daten aus einer CSV - Datei und generiert daraus wieder ein Objekt.
	 * @param dateiName Der DateiName der CSV.
	 * @return das geladene Objekt aus den Daten der CSV.
	 * @since 1.0.0
	 */
	public static PersonenVerwaltung ladeCSV(String dateiName) {
		return null;
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