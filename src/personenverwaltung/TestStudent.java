package personenverwaltung;

public class TestStudent {
	public static void main(String[] args) {
		Student student1 = new Student("Alfred","Loran","Hegelstrasse",10,"Reutlingen","72762");
		Vorlesung vorlesung = new Vorlesung("Informatik 2");
		Dozent dozent = new Dozent("Frank", "Dopatka", "Mir doch egal", 24, "Irgend ein Ort", "12345");
		dozent.haeltVorlesung(vorlesung);
		System.out.println(vorlesung);
		System.out.println();
		System.out.println(student1);
		System.out.println();
		System.out.println(vorlesung);
		student1.nimmtAnVorlesungTeil(vorlesung);
		System.out.println();
		System.out.println();
		System.out.println(student1);
		dozent.trageNoteEin(2.3);
		System.out.println();
		System.out.println(student1);
	}
}
