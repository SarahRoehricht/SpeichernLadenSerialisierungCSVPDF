package backend;

import java.io.Serializable;

/**
 * This class represents the address.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class Address implements Serializable {
	private static final long serialVersionUID = 2940819290418119477L;
	private String street;
	private int houseNumber;
	private String place;
	private String postalCode;
	
	/**
	 * Generates an address object.
	 * @since 1.0.0
	 */
	public Address() {}
	
	/**
	 * Generates an address object with the passed parameters.
	 * @param street The passed street.
	 * @param houseNumber The passed houseNumber.
	 * @param place The passed place.
	 * @param postalCode The passed postal code
	 * @since 1.0.0
	 */
	public Address(String street, int houseNumber, String place, String postalCode) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.place = place;
		this.postalCode = postalCode;
	}
	
	/**
	 * Returns the street.
	 * @return the street.
	 * @since 1.0.0
	 */
	protected String getStreet() {
		return street;
	}
	
	/**
	 * Sets the street.
	 * @param street The passed street.
	 * @since 1.0.0
	 */
	protected void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Returns the house number.
	 * @return the house number.
	 * @since 1.0.0
	 */
	protected int getHouseNumber() {
		return houseNumber;
	}
	
	/**
	 * Sets the house number
	 * @param houseNumber The passed house number.
	 * @since 1.0.0
	 */
	protected void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	/**
	 * Returns the place.
	 * @return the place
	 * @since 1.0.0
	 */
	protected String getPlace() {
		return place;
	}
	
	/**
	 * Sets the place.
	 * @param place The pased place.
	 * @since 1.0.0
	 */
	protected void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * Returns the postal code.
	 * @return the postal code
	 * @since 1.0.0
	 */
	protected String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Sets the postal code.
	 * @param postalCode The passed postal code.
	 * @since 1.0.0
	 */
	protected void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Returns the data of the object.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		String outputString = "";
		if((getStreet() != null) && (getHouseNumber() != 0) && 
		   (getPlace() != null) && (getPostalCode() != null)) {
			outputString += "Street: " + getStreet()+ "\n" +
							"House number: " + getHouseNumber() + "\n" + 
							"Place: " + getPlace() + "\n" +
							"Postal code: " + getPostalCode() + "\n";
		} else {
			outputString += "There is no address!";
		}
		return outputString;
	}
}