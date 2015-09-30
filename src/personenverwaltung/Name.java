package personenverwaltung;

import exceptions.UngueltigeEingabeException;

/**
 * Diese Klasse bildet den Namen ab.
 * Ein Name besteht aus einem Vornamen und einem Nachnamen.
 * @author  Alfred Loran
 * @version 1.0.0
 */
class Name {
	private static int anzahlNamenObjekte = 0;
	private int nameObjektNummer;
	private String vorName;
	private String nachName;
	
	/**
	 * Erzeugt ein Name - Objekt.
	 * @since 1.0.0
	 */
	protected Name() {
		setNameObjektNummer(++anzahlNamenObjekte);
	}
	
	/**
	 * Erzeugt ein Name - Objekt mit dem uebergebenem Parameter.
	 * @param vorName Der uebergebene Vorname.
	 * @since 1.0.0
	 */
	protected Name(String vorName) {
		this();
		setVorName(vorName);
	}
	
	/**
	 * Erzeugt ein Name - Objekt mit dem uebergebenem Parameter.
	 * @param vorName Der uebergebene Vorname.
	 * @param nachName Der uebergebene Nachname.
	 * @since 1.0.0
	 */
	protected Name(String vorName, String nachName) {
		this(vorName);
		setNachName(nachName);
	}


	/**
	 * Diese Methode liefert den Vornamen.
	 * @return den Vornamen.
	 * @since 1.0.0
	 */
	protected String getVorName() {
		return vorName;
	}

	/**
	 * Diese Methode setzt den Vornamen.
	 * @param vorName Der uebergebene Vorname.
	 * @since 1.0.0
	 */
	private void setVorName(String vorName) {
		if(vorName == null) {
			throw new NullPointerException("Kein Vorname vorhanden!");
		} else {
			if(vorName.length() < 2) {
				throw new UngueltigeEingabeException("Geben Sie mindestens 2 Zeichen als Vornamen ein!");
			} else {
				this.vorName = vorName;
			}
		}
	}

	/**
	 * Liefert den Nachnamen.
	 * @return den Nachnamen.
	 * @since 1.0.0
	 */
	protected String getNachName() {
		return nachName;
	}

	/**
	 * Diese Methode setzt den Nachnamen.
	 * @param nachName Der ueergebene Nachname.
	 * @since 1.0.0
	 */
	private void setNachName(String nachName) {
		if(nachName == null) {
			throw new NullPointerException("Kein Nachname vorhanden!");
		} else {
			if(nachName.length() < 2) {
				throw new UngueltigeEingabeException("Geben Sie mindestens 2 Zeichen als Nachnamen ein!");
			} else {
				this.nachName = nachName;
			}
		}
	}

	/**
	 * Liefert die Nummer des Name - Objektes.
	 * @return die Nummer des Name - Objektes.
	 * @since 1.0.0
	 */
	private int getNameObjektNummer() {
		return nameObjektNummer;
	}

	/**
	 * Diese Methode setzt die Nummer des Name - Objektes.
	 * @param nameObjektNummer Die uebergebene Nummer.
	 * @since 1.0.0
	 */
	private void setNameObjektNummer(int nameObjektNummer) {
		this.nameObjektNummer = nameObjektNummer;
	}
	
	/**
	 * Diese Methode liefert die Daten des Objektes.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		return	"Vorname: " + getVorName() + ", Nachname: " + getNachName();
	}
	
	/**
	 * Diese Methode vergleicht zwei Objekte.
	 * @param object Das zu vergleichende Objekt.
	 * @return true, Objekte sind gleich.
	 * 		   false, Objekte sind ungleich.
	 * @since 1.0.0
	 */
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
		} else if(!(object instanceof Name)) {
			return false;
		} else {
			Name name = (Name)object;
			return ((name.getNameObjektNummer() == this.getNameObjektNummer()) && name.getVorName().equals(this.getVorName()) && (name.getNachName().equals(this.getNachName())));
		}
	}
}