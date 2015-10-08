import backend.StudentAdministration;
import interfaces.iCSV;
import interfaces.iStudent;

public class TestSaveCSV {	
	public static void main(String[] args) {
		StudentAdministration sA = new StudentAdministration();
		iStudent student = sA;
		iCSV csv = sA;
		student.generateStudent("Alfred", "Loran", "You wish", 10, "Reutlingen", "72762");
		student.generateStudent("Max", "Mustermann", "Musterstrasse", 1, "Mussterstadt", "12345");		
		System.out.println(student);
		csv.saveCSV("TestCSV");
	}
}