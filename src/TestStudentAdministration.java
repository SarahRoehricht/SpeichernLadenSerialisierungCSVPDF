import backend.StudentAdministration;
import interfaces.iStudent;

/**
 * Test class for testing the backend.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class TestStudentAdministration {
	public static void main(String[] args) {
		StudentAdministration sA = new StudentAdministration();
		iStudent student = sA;
		student.generateStudent("Alfred", "Loran", "Hegelstrasse", 10, "Reutlingen", "72762");
		System.out.println(student);
	}
}