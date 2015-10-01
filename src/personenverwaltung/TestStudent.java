package personenverwaltung;

public class TestStudent {
	public static void main(String[] args) {
		Student student1 = new Student("Alfred","Loran","Hegelstrasse",10,"Reutlingen","72762");
		Vorlesung vorlesung = new Vorlesung("Informatik 2");
		System.out.println(student1);
		System.out.println(vorlesung);
		student1.nimmtAnVorlesungTeil(vorlesung);
		System.out.println(student1);
		vorlesung.setNote(2.3);
		System.out.println(student1);
	}
}
