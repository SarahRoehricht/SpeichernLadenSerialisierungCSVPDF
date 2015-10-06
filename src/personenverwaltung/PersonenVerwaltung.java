package personenverwaltung;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
	private static Dozent geladenerDozent = null;
	private static Vorlesung geladeneVorlesung = null;
	private static Student geladenerStudent = null;
	private Student student;
	private Dozent dozent;
	private Vorlesung vorlesung;
	private PersonenVerwaltung pV;
	
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
		if(dozent.getVorlesung().getVorlesungsName().equals(nameVorlesung)) {
			student.nimmtAnVorlesungTeil(dozent.getVorlesung());	
		} else {
			System.out.println("Nope");
		}
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
			String plzNullString = "00000";
			
			//Daten fuer den Dozenten
			if(this.dozent != null) {
				String dozentVorname = dozent.getName().getVorName();
				csv.schreiben(dozentVorname);
				String dozentenNachname = dozent.getName().getNachName();
				csv.schreiben(dozentenNachname);
				String dozentenStrasse = dozent.getAdresse().getStrasse();
				csv.schreiben(dozentenStrasse);
				String dozentenHausNummer = "" + dozent.getAdresse().getHausNummer();
				csv.schreiben(dozentenHausNummer);
				String dozentenOrt = dozent.getAdresse().getOrt();
				csv.schreiben(dozentenOrt);
				String dozentenPLZ = dozent.getAdresse().getPostLeitZahl();
				csv.schreiben(dozentenPLZ);
			} else {
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
				String dozentenPLZ = plzNullString;
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
				String studentVorname = student.getName().getVorName();
				csv.schreiben(studentVorname);
				String studentenNachname = student.getName().getNachName();
				csv.schreiben(studentenNachname);
				String studentenStrasse = student.getAdresse().getStrasse();
				csv.schreiben(studentenStrasse);
				String studentHausnummer = "" + student.getAdresse().getHausNummer();
				csv.schreiben(studentHausnummer);
				String studentOrt = student.getAdresse().getOrt();
				csv.schreiben(studentOrt);
				String studentPLZ = student.getAdresse().getPostLeitZahl();
				csv.schreiben(studentPLZ);
				String studentenVorlesungName = student.getVorlesungsName();
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
				String studentPLZ = plzNullString;
				csv.schreiben(studentPLZ);
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
	private static PersonenVerwaltung ladeCSV(String dateiName) {
		CSV csv = new CSV();
    	Properties properties = new Properties();
    	properties.setProperty("Dateiname", dateiName + ".csv");
    	properties.setProperty("Modus", "l");
    	
    	try {
    		csv.oeffnen(properties);
    		ArrayList<String> ausgabe = (ArrayList<String>)csv.lesen();
    		String[] ausgeleseneObjekte = new String[17];
    		for(int i = 0; i < ausgeleseneObjekte.length; i++) {
    			ausgeleseneObjekte = ausgabe.get(0).split(",");
    		}
    		PersonenVerwaltung pV = new PersonenVerwaltung();
    		
    		//Daten des Dozenten
    		String dozentenVorname = ausgeleseneObjekte[0];
    		String dozentNachname = ausgeleseneObjekte[1];
    		String dozentStrasse = ausgeleseneObjekte[2];
    		String dozentHausNummer = ausgeleseneObjekte[3];
    		int dZHN = Integer.parseInt(dozentHausNummer);
    		String dozentOrt = ausgeleseneObjekte[4];
    		String dozentPLZ = ausgeleseneObjekte[5];
    		Dozent dozent = new Dozent(dozentenVorname, dozentNachname, dozentStrasse, dZHN, dozentOrt, dozentPLZ);
    		PersonenVerwaltung.geladenerDozent = dozent;  
    		
    		//Daten der Vorlesung
    		String vorlesungsKuerzel = ausgeleseneObjekte[6];
    		String vorlesungName = ausgeleseneObjekte[7];
    		Vorlesung vorlesung = new Vorlesung(vorlesungName);
    		vorlesung.setVorlesung(vorlesungsKuerzel, vorlesungName, dozent);
    		PersonenVerwaltung.geladeneVorlesung = vorlesung;
    		
    		//Daten des Studenten
    		String matrikelNummer = ausgeleseneObjekte[8];
    		String studentVorname = ausgeleseneObjekte[9];
    		String studentnachname = ausgeleseneObjekte[10];
    		String studentenStrasse = ausgeleseneObjekte[11];
    		String studHNR = ausgeleseneObjekte[12];
    		int studentHausNummer = Integer.parseInt(studHNR);
    		String studentOrt = ausgeleseneObjekte[13];
    		String studentPLZ = ausgeleseneObjekte[14];
    		String studentVorlesung = ausgeleseneObjekte[15];
    		String n = ausgeleseneObjekte[16];
    		double note = Double.parseDouble(n);
    		Student student = new Student(studentVorname, studentnachname, studentenStrasse, studentHausNummer, studentOrt, studentPLZ);
    		if(studentVorlesung == null) {
    			student.setVorlesung(null);
    		} else {
    			student.nimmtAnVorlesungTeil(geladeneVorlesung);
        		student.setGeladeneNote(note);
        		PersonenVerwaltung.geladenerStudent = student;
    		}    		    	
    		return pV;
    	} catch(IOException fehler) {
    		System.err.println(fehler.getMessage());
    	}
		
		return null;
	}	
	
	@Override
	public PersonenVerwaltung ladecsv(String dateiName) {		
		this.pV = PersonenVerwaltung.ladeCSV(dateiName);
		this.dozent = PersonenVerwaltung.geladenerDozent;
	    this.vorlesung = PersonenVerwaltung.geladeneVorlesung;
		this.student = PersonenVerwaltung.geladenerStudent;
		return pV;
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