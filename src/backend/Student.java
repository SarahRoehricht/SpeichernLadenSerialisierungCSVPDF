package backend;

import java.io.Serializable;

/**
 * This class represents a student.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class Student implements Serializable {
	private static final long serialVersionUID = -6535321431081443080L;
	private String studentNumber;
	private Name name;
	private Address address;
	
	/**
	 * Generates a student object.
	 * @since 1.0.0
	 */
	public Student() {}
	
	/**
	 * Generates a student object with the passed parameters.
	 * @param preName The passed prename.
	 * @param surName The passed surname.
	 * @param street The passed street.
	 * @param houseNumber The passed house number.
	 * @param place The passed place.
	 * @param postalCode The passed postal code.
	 * @since 1.0.0
	 */
	public Student(String preName, String surName, String street, 
			          int houseNumber, String place, String postalCode) {
		this.name = new Name(preName, surName);
		this.address = new Address(street, houseNumber, place, postalCode);
		generateStudentNumber();
	}
	
	/**
	 *  This method generates fictional student number.
	 *  @since 1.0.0
	 */
	private void generateStudentNumber() {
		studentNumber = getName().getPreName().substring(0, 2) + getName().getSurName().substring(0, 2) + 
				        getAddress().getPostalCode();
	}

	/**
	 * Returns the student number
	 * @return the student number.
	 * @since 1.0.0
	 */
	public String getStudentNumber() {
		return studentNumber.toUpperCase();
	}

	/**
	 * Sets the student number.
	 * @param studentNumber The passed student number.
	 * @since 1.0.0
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * Returns the name object.
	 * @return the name object.
	 * @since 1.0.0
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the name object.
	 * @param name The passed name object.
	 * @since 1.0.0
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Returns the address object.
	 * @return the address object.
	 * @since 1.0.0
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the address object.
	 * @param address The passed address object.
	 * @since 1.0.0
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * Returns the data of the object.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		String outputString = "";
		if((this.studentNumber == null) && (this.name == null) && (this.address == null)) {
			outputString = "There is no Student!";
		} else {
			outputString = 	"Student number: " + getStudentNumber() + "\n" +
							getName().toString() + getAddress().toString();
		}
		return outputString;
	}
}