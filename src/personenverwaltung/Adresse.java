package personenverwaltung;

import java.io.Serializable;

import exceptions.UngueltigeEingabeException;

/**
 * Diese Klasse bildet die Adresse ab.
 * @author Alfred Loran
 * @version 1.0.0
 */
class Adresse implements Serializable {
	private static final long serialVersionUID = -2477723777225965585L;
	private static int anzahlAdresseObjekt;
	private int adresseObjektNummer;
	private String strasse;
	private int hausNummer;
	private String ort;
	private String postLeitZahl;
	
	/**
	 * Erzeugt ein Adresse - Objekt.
	 * @since 1.0.0
	 */
	protected Adresse() {
		setAdresseObjektNummer(++anzahlAdresseObjekt);
	}
	
	/**
	 * Erzuegt ein Adresse - Objekt mit den uebergebenen Parametern.
	 * @param strasse Die uebergebene Strasse.
	 * @param hausNummer Die uebergebene Hausnummer.
	 * @param ort Der uebergebene Ort.
	 * @param plz Die uebergebene Postleitzahl.
	 */
	protected Adresse(String strasse, int hausNummer, String ort, String plz) {
		this();
		setStrasse(strasse);
		setHausNummer(hausNummer);
		setOrt(ort);
		setPostLeitZahl(plz);
	}

	/**
	 * Liefert die Nummer des Adresse - Objekt.
	 * @return die Nummer des Adresse - Objekt.
	 * @since 1.0.0
	 */
	private int getAdresseObjektNummer() {
		return adresseObjektNummer;
	}

	/**
	 * Setzt die Nummer des Adresse - Objekt.
	 * @param adresseObjektNummer Die uebergebene Nummer.
	 * @since 1.0.0
	 */
	private void setAdresseObjektNummer(int adresseObjektNummer) {
		this.adresseObjektNummer = adresseObjektNummer;
	}

	/**
	 * Liefert die Strasse.
	 * @return die Strasse.
	 * @since 1.0.0
	 */
	protected String getStrasse() {
		return strasse;
	}

	/**
	 * Setzt die Strasse.
	 * @param strasse Die uebergebene Strasse.
	 * @since 1.0.0
	 */
	private void setStrasse(String strasse) {
		if(strasse == null) {
			throw new NullPointerException("Keine Strasse vorhanden!");
		} else {
			if(strasse.length() < 3) {
				throw new UngueltigeEingabeException("Geben Sie 3 Zeichen als Strasse ein!");
			} else {
				this.strasse = strasse;
			}
		}
	}

	/**
	 * Liefert die Hausnummer.
	 * @return die Hausnummer.
	 * @since 1.0.0
	 */
	protected int getHausNummer() {
		return hausNummer;
	}

	/**
	 * Setzt die Hausnummer.
	 * @param hausNummer Die uebergebene Hausnummer.
	 * @since 1.0.0
	 */
	private void setHausNummer(int hausNummer) {
		if(hausNummer <= 0) {
			throw new UngueltigeEingabeException("Geben Sie eine posiive Zahl ein!");
		} else {
			this.hausNummer = hausNummer;
		}
	}

	/**
	 * Lieferte den Ort.
	 * @return den Ort.
	 * @since 1.0.0
	 */
	protected String getOrt() {
		return ort;
	}

	/**
	 * Setzt den Ort.
	 * @param ort Der uebergebene Ort.
	 * @since 1.0.0
	 */
	private void setOrt(String ort) {
		if(ort == null) {
			throw new NullPointerException("Kein Ort vorhanden!");
		} else {
			if(ort.length() < 2) {
				throw new UngueltigeEingabeException("Bitte geben Sie mindestens 2 Zeichen als Ort ein!");
			} else {
				this.ort = ort;
			}
		}
	}

	/**
	 * Liefert die Postleitzahl.
	 * @return die Postleitzahl.
	 * @since 1.0.0
	 */
	protected String getPostLeitZahl() {
		return postLeitZahl;
	}

	/**
	 * Setzt die Postleitzahl.
	 * @param postLeitZahl Die uebergebene Postleitzahl.
	 * @since 1.0.0
	 */
	private void setPostLeitZahl(String postLeitZahl) {
		if(postLeitZahl == null) {
			throw new NullPointerException("Keine Postleitzahl vorhanden!");
		} else {
			if(postLeitZahl.length() != 5) {
				throw new UngueltigeEingabeException("Bitte geben Sie genau 5 Zeichen ein!");
			} else {
				if(!(postLeitZahl.matches("\\d+"))) {
					throw new UngueltigeEingabeException("Bitte geben Sie nur Zahlen ein!");
				} else {
					this.postLeitZahl = postLeitZahl;
				}
			}
		}
	}	
	
	/**
	 * Liefert die Daten des Objektes.
	 * @return die Daten des Objektes.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		return 	"Strasse: " + getStrasse() + "\n" +
				"Hausnummer: " + getHausNummer() + "\n" +
				"Ort: " + getOrt() + "\n" +
				"PLZ: " + getPostLeitZahl();
	}
	
	/**
	 * Diese Methode vergleicht zwei Objekte.
	 * @param object Das zu vergleichende Objekt.
	 * @return true, Objekte sind gleich.
	 * 		   false, Objekte sind falsch.
	 * @since 1.0.0
	 */
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
		} else if(!(object instanceof Adresse)) {
			return false;
		} else {
			Adresse adresse = (Adresse)object;
			return ((adresse.getAdresseObjektNummer() == this.getAdresseObjektNummer()) && (adresse.getStrasse().equals(this.getStrasse()) && 
					(adresse.getHausNummer() == this.hausNummer) && (adresse.getOrt().equals(this.getOrt()) && (adresse.getPostLeitZahl().equals(this.getPostLeitZahl())))));
		}
	}
}