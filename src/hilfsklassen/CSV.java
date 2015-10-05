package hilfsklassen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Properties;

import interfaces.iSpeichernLaden;

/**
 * Diese Klasse bildet das Speichern und Laden in einer CSV DAtei ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class CSV implements iSpeichernLaden {
	private BufferedReader br;
	private BufferedWriter bw;
		
	@Override
	public void oeffnen(Properties p) throws IOException {
		String dateiName = p.getProperty("Dateiname");
		
		if(dateiName == null) {
			throw new IOException("Dateiname wurde nicht definiert!");
		}
		
		if("s".equals(p.getProperty("Modus"))) {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dateiName)));
		} else if("l".equals(p.getProperty("Modus"))) {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(dateiName)));
		} else {
			throw new IOException("Modus wurde nicht definiert!");
		}
	}

	@Override
	public void schreiben(Object object) throws IOException {
		Object[][] daten = (Object[][])object;
		
		for(Object[] linie : daten) {
			boolean erster = true;
			
			for(Object feld: linie) {
				if(erster) {
					erster = false;
				} else {
					bw.write(",");
				}
				
				if(feld != null) {
					bw.write(feld.toString());
				}
			}
			bw.write("\n");
		}
	}

	@Override
	public Object lesen() throws IOException {
		String line;
		ArrayList<String> linien = new ArrayList<String>();
		
		while((line = br.readLine()) != null) {
			linien.add(line);
		}
		
		String[][] ausgabe = new String[linien.size()][];
		
		for(int i = 0; i < ausgabe.length; i++) {
			ausgabe[i] = linien.get(i).split(",");
		}
		return ausgabe;
	}

	@Override
	public void schliessen(Object object) throws IOException {
		if(bw != null) {
			bw.close();
			bw = null;
		}
		
		if(br != null) {
			br.close();
			br = null;
		}
	}
}