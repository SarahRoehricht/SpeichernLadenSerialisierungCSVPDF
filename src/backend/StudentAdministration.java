package backend;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Properties;

import classes.PDF;
import classes.Serialize;
import interfaces.iPDF;
import interfaces.iSerialize;
import interfaces.iStudent;

/**
 * This class represents the student administration.
 * The class contains the methods to generate students
 * and do some other stuff.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class StudentAdministration implements Serializable, iStudent, iSerialize, iPDF {
	private static final long serialVersionUID = -7061702237466525514L;
	private HashSet<Student> studentSet;
	
	/**
	 * Generates a new student administration object
	 * and initialising an HashSet of students.
	 * @since 1.0.0
	 */
	public StudentAdministration() {
		this.studentSet = new HashSet<Student>();
	}
	
	/**
	 * This method adds a student to the set.
	 * @param student The passed student.
	 * @since 1.0.0
	 */
	private void addStudent(Student student) {
		studentSet.add(student);
	}
	
	/**
	 * This method generates a new Student.
	 * @param preName The passed preName.
	 * @param surName The passed surName.
	 * @param street The passed street.
	 * @param houseNumber The passed house number.
	 * @param place The passed place.
	 * @param postalCode The passed postal code.
	 * @since 1.0.0
	 */
	@Override
	public void generateStudent(String preName, String surName, String street, int houseNumber, String place, String postalCode) {
		Student student = new Student(preName, surName, street, houseNumber, place, postalCode);
		addStudent(student);
	}
	
	/**
	 * This method removes a student.
	 * @param studentNumber The passed student number.
	 * @since 1.0.0
	 */
	@Override
	public void removeStudent(String studentNumber) {
		for(Student student : studentSet) {
			if(student.getStudentNumber().equals(studentNumber)) {
				studentSet.remove(student);
			}
		}
	}
	
	/**
	 * This method serializes the data of the program.
	 * @param fileName The passed fileName.
	 * @since 1.0.0
	 */
	@Override
	public void saveSerialize(String fileName) {
		Serialize serial = new Serialize();
        Properties properties = new Properties();
        properties.setProperty("Filename",fileName + ".ser");
        properties.setProperty("Mode", "s");

        try {
            serial.open(properties);
            serial.write(this);
        } catch(IOException fehler) {
            System.err.println(fehler.getMessage());
        } finally {
            try {
                serial.close(null);
            } catch(IOException fehler) {
                System.err.println(fehler.getMessage());
            }
        }		
	}

	/**
	 * This method loads the serialized data.
	 * @param fileName The passed file name.
	 * @return the loaded object.
	 * @since 1.0.0
	 */
	@Override
	public Object loadSerialize(String fileName) {
		Serialize serial = new Serialize();
        Properties properties = new Properties();
        properties.setProperty("Filename", fileName + ".ser");
        properties.setProperty("Mode", "l");
        try {
            serial.open(properties);
            StudentAdministration sA = (StudentAdministration)serial.read();
            return sA;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                serial.close(null);
            } catch (IOException fehler) {
                System.out.println(fehler.getMessage());
            }
        }
        return null;
	}	
	
	/**
	 * This method save the data in a PDF file.
	 * @param fileName The passed file name.
	 * @since 1.0.0
	 */
	@Override
	public void savePDF(String fileName) {
		PDF pdf = new PDF();
		Properties properties = new Properties();
		properties.setProperty("Filename", fileName + ".pdf");
		properties.setProperty("Mode", "s");
		
		try {
			pdf.open(properties);
			pdf.write(toString());
		} catch(IOException error) {
			System.err.println(error.getMessage());
		} finally {
			try {
				pdf.close(null);
			} catch(IOException error) {
				System.err.println(error.getMessage());
			}
		}
	}
	
	/**
	 * Returns the data of the object.
	 * @since 1.0.0
	 */
	@Override
	public String toString(){
		String outputString = "";
		for(Student student : studentSet) {
			outputString += student.toString() + "\n";
		}
		return outputString;
	}
}