import backend.StudentAdministration;
import interfaces.iSerialize;

/**
 * This class tests if the programm can load serialized datas.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class TestLoadSerial {
	public static void main(String[] args) {
		StudentAdministration sA = new StudentAdministration();
		iSerialize serialize = sA;
		StudentAdministration studentAdministration = (StudentAdministration)serialize.loadSerialize("TestSerialize");
		System.out.println(studentAdministration);
	}
}