package classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import interfaces.iData;

/**
 * This class contains the methods to save the data in a pdf.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class PDF implements iData {
	private Document document;
	
	@Override
	public void open(Properties properties) throws IOException {
		document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(properties.getProperty("Filename")));
			document.open();
		} catch(DocumentException error) {
			throw new IOException("PDF Writer konnte nicht erzeugt werden.");
		}
	}

	@Override
	public void write(Object object) throws IOException {
		try {
			document.add(new Paragraph(object.toString()));
		}catch(DocumentException error) {
			throw new IOException("Could not write into PDF!");
		}		
	}

	@Override
	public Object read() throws IOException {
		throw new IOException("You can't load from a PDF file");
	}

	@Override
	public void close(Object object) throws IOException {
		document.close();
	}
}