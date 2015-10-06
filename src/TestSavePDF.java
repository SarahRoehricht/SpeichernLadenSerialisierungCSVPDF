import backend.StudentAdministration;
import interfaces.iPDF;
import interfaces.iSerialize;
import interfaces.iStudent;

/**
 * Testclass for saving data into a PDF file.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class TestSavePDF {
	public static void main(String[] args) {
		StudentAdministration sA = new StudentAdministration();
		iStudent student = sA;
		iSerialize serialize = sA;
		iPDF pdf = sA;
		student.generateStudent("Alfred", "Loran", "You wish", 10, "Reutlingen", "72762");
		student.generateStudent("Max", "Mustermann", "Musterstrasse", 1, "Mussterstadt", "12345");
		System.out.println(student);
		serialize.saveSerialize("TestSerialize");
		pdf.savePDF("TestPDF");
	}

}
