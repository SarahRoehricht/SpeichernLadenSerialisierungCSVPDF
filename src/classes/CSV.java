package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Properties;

import interfaces.iData;

public class CSV implements iData {
	private BufferedReader br;
	private BufferedWriter bw;

	@Override
	public void open(Properties properties) throws IOException {
		String fileName = properties.getProperty("Filename");
		
		if(fileName == null) {
			throw new IOException("Filename not defined!");
		}
		
		if("s".equals(properties.getProperty("Mode"))) {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		} else if("l".equals(properties.getProperty("Mode"))) {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		} else {
			throw new IOException("Mode not defined!");
		}		
	}

	@Override
	public void write(Object object) throws IOException {
		String daten = (String)object;
		bw.write(daten + ",");
	}

	@Override
	public Object read() throws IOException {
		String linie;
		ArrayList<String> linien = new ArrayList<String>();		
		while((linie = br.readLine()) != null) {
			linien.add(linie);
		}			
		return linien;
	}

	@Override
	public void close(Object object) throws IOException {
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
