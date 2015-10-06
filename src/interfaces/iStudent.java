package interfaces;
/**
 * This interface contains the methods for a student.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iStudent {
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
	public void generateStudent(String preName, String surName, String street,
			                    int houseNumber, String place, String postalCode);
	
	/**
	 * This method removes a student.
	 * @param studentNumber The passed student number.
	 * @since 1.0.0
	 */
	public void removeStudent(String studentNumber);
}