import interfaces.iDozent;
import interfaces.iSpeichernLadenSerialisiert;
import interfaces.iSpeichernPDF;
import interfaces.iStudent;
import personenverwaltung.PersonenVerwaltung;

public class TestSpeichernPDF {

	public static void main(String[] args) {
		iDozent dozent;
		iStudent student;
		iSpeichernLadenSerialisiert ser;
		iSpeichernPDF pdf;
		PersonenVerwaltung pV = new PersonenVerwaltung();
		dozent = pV; student = pV; ser = pV; pdf = pV;
		dozent.erstelleDozenten("Frank", "Dopatka", "Musterstrasse", 1, "Musterort", "12345");
		dozent.erstelleVorlesung("Informatik 2");
		System.out.println(dozent);	
		student.erzeugeStudenten("Alfred", "Loran", "Geht euch n scheiss an", 10, "Reutlingen", "72762");
		System.out.println(student);
		student.nehmeAnVorlesungTeil("Informatik 2");
		System.out.println(student);
		dozent.trageNoteEin(1.3);
		System.out.println(dozent);
		pdf.speichernPDF("PDF");
	}
}