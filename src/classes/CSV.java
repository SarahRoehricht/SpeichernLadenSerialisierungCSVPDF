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

import backend.Address;
import backend.Name;
import backend.Student;
import backend.StudentAdministration;
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
		if(daten.equals("#")) {
			bw.write("\n");
		} else {
			bw.write(daten + ",");
		}		
	}

	@Override
	public Object read() throws IOException {
		String linie;
		ArrayList<String> linien = new ArrayList<String>();
		ArrayList<Student> students = new ArrayList<>();
		while((linie = br.readLine()) != null) {
			linien.add(linie);
			String[] readedAttributes = new String[7];			
			for(int i = 0; i < readedAttributes.length; i++) {
    			readedAttributes = linien.get(0).split(",");
    		}
			
			if(readedAttributes[0] == null) {
    			return students;
    		} else {
    			String studentNumber = readedAttributes[0];
    			String preName = readedAttributes[1];
    			String surName = readedAttributes[2];
    			String street = readedAttributes[3];
    			int houseNumber = Integer.parseInt(readedAttributes[4]);
    			String place = readedAttributes[5];
    			String postalCode = readedAttributes[6];
    			StudentAdministration sA = new StudentAdministration();
    			Student student = new Student();
    			student.setStudentNumber(studentNumber);
    			student.setName(new Name(preName,surName));
    			student.setAddress(new Address(street, houseNumber, place, postalCode));
    			students.add(student);
    		}
			linien.remove(linie);
		}			
		return students;
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
