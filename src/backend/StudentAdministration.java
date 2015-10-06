package backend;

import java.io.Serializable;
import java.util.HashSet;

import interfaces.iStudent;

/**
 * This class represents the student administration.
 * The class contains the methods to generate students
 * and do some other stuff.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class StudentAdministration implements Serializable, iStudent {
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
	 * Returns the data of the object.
	 * @since 1.0.0
	 */
	@Override
	public String toString(){
		String outputString = "";
		for(Student student : studentSet) {
			outputString += student.toString();
		}
		return outputString;
	}	
}