import backend.StudentAdministration;
import interfaces.iCSV;
import interfaces.iStudent;

/**
 * This class loads the programm from a CSV file.
 * @author Alfred Loran
 * @version1.0.0
 */
public class TestLoadCSV {
	public static void main(String[] args) {
		StudentAdministration sA = new StudentAdministration();
		iCSV csv = sA;
		StudentAdministration studentAdministration = (StudentAdministration)csv.loadCSV("TestCSV");
		iStudent student = studentAdministration;
		csv = studentAdministration;
		System.out.println(studentAdministration);
	}
}