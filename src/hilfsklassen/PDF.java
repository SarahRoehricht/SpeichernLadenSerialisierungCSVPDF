package hilfsklassen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import interfaces.iSpeichernLaden;

/**
 * Diese Klasse bildet das Speichern auf einer PDF ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class PDF implements iSpeichernLaden {
	private Document document;
	
	/**
	 * Oeffnet ein PDF Dokument.
	 * @param Das uebergebene Properties - Objekt.
	 * @since 1.0.0
	 */
	@Override
	public void oeffnen(Properties p) throws IOException {
		document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(p.getProperty("dateiName")));
			document.open();
		} catch(DocumentException fehler) {
			throw new IOException("PDF Writer konnte nicht erzeut werden.");
		}
	}

	/**
	 * Schreibt die PDF.
	 * @param object Das uebergebene zu schreibende Objekt.
	 * @since 1.0.0
	 */
	@Override
	public void schreiben(Object object) throws IOException {
		try {
			document.add(new Paragraph(object.toString()));
		} catch(DocumentException fehler) {
			throw new IOException("Konnte PDF nicht schreiben!");
		}
	}

	@Override
	public Object lesen() throws IOException {
		//Nope nope nope. Ohne enormen Aufwand ist man nicht in der Lage aus einer PDF zu laden.
		//Dies würde nur gehen wenn ihr versucht aus den Metadaten der PDF eure Objekte zu erzeugen.
		//Dies ist aber für INF 2 echt nicht notwendig.
		return null;
	}

	/**
	 * Schliesst das Document wieder.
	 * @param object Das zu schließende Objekt.
	 * @since 1.0.0
	 */
	@Override
	public void schliessen(Object object) throws IOException {
		document.close();
	}
}