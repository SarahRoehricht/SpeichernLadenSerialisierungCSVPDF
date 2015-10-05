package personenverwaltung;

import java.io.Serializable;

/**
 * Diese Klasse bildet eine Person ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
abstract class Person implements Serializable{
	private static final long serialVersionUID = 5859672337581572952L;
	private static int anzahlPersonenObjekte;
	private int personenNummer;
	private Name name;
	private Adresse adresse;
	
	/**
	 * Erzeugt ein Personen - Objekt.
	 * @since 1.0.0
	 */
	protected Person() {
		setPersonenNummer(++anzahlPersonenObjekte);
	}
	
	/**
	 * Erzeugt ein Person - Objekt mit den uebergebenen Parametern.
	 * @param vorName Der uebergebene Vorname.
	 * @param nachName Der uebergebene Nachname.
	 * @param strasse Die uebergebene Strasse.
	 * @param hausNummer Die uebergebene Hausnummer.
	 * @param ort Der uebergebene Ort.
	 * @param plz Die uebergebene Postleitzahl.
	 * @since 1.0.0
	 */
	protected Person(String vorName, String nachName, String strasse, 
			         int hausNummer, String ort, String plz) {
		this();
		setName(new Name(vorName,nachName));
		setAdresse(new Adresse(strasse, hausNummer, ort, plz));
	}	

	/**
	 * Liefert die Personennummer.
	 * @return die Personennummer.
	 * @since 1.0.0
	 */
	protected int getPersonenNummer() {
		return personenNummer;
	}


	/**
	 * Setzt die Personennummer.
	 * @param personenNummer Die uebergebene Personennummer.
	 * @since 1.0.0
	 */
	private void setPersonenNummer(int personenNummer) {
		this.personenNummer = personenNummer;
	}

	/**
	 * Liefert das Name - Objekt.
	 * @return das Name - Objekt.
	 * @since 1.0.0
	 */
	protected Name getName() {
		return name;
	}

	/**
	 * Setzt das Name - Objekt.
	 * @param name Das uebergebene Name - Objekt.
	 * @since 1.0.0
	 */
	private void setName(Name name) {
		this.name = name;
	}

	/**
	 * Liefert das Adresse - Objekt.
	 * @return das Adresse - Objekt.
	 * @since 1.0.0
	 */
	protected Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setzt das Adresse - Objekt.
	 * @param adresse Das uebergebene Adresse - Objekt.
	 * @since 1.0.0
	 */
	private void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Liefert die Daten des Objektes.
	 * @return die Daten des Objektes.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		return getName().toString() + "\n" + getAdresse().toString() + "\n";
	}
	
	/**
	 * Vergleicht zwei Objekte.
	 * @param object Das zu vergleichende Objekt.
	 * @return true, Objekte sind gleich.
	 * 		   false, Objekte sind ungleich.
	 * @since 1.0.0
	 */
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			throw new NullPointerException("kein Objekt zum Vergleichen vorhanden!");
		} else if(!(object instanceof Person)) {
			return false;
		} else {
			Person p = (Person)object;
			return (p.getPersonenNummer() == this.getPersonenNummer()) && 
				   (p.getName().equals(this.getName()) &&
				   (p.getAdresse().equals(this.getAdresse())));
		}
	}	
}