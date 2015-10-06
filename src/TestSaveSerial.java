import backend.StudentAdministration;
import interfaces.iSerialize;
import interfaces.iStudent;

/**
 * This class tests the programm for serializing the data.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class TestSaveSerial {
	public static void main(String[] args) {
		StudentAdministration sA = new StudentAdministration();
		iStudent student = sA;
		iSerialize serialize = sA;
		student.generateStudent("Alfred", "Loran", "You wish", 10, "Reutlingen", "72762");
		student.generateStudent("Max", "Mustermann", "Musterstrasse", 1, "Mussterstadt", "12345");
		System.out.println(student);
		serialize.saveSerialize("TestSerialize");
	}
}