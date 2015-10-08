package backend;

import java.io.Serializable;

/**
 * This class represents a name.
 * @author Alfred Loran
 * @version 1.0.0
 */
public class Name implements Serializable {
	private static final long serialVersionUID = -3222162171869596544L;
	private String preName;
	private String surName;
	
	/**
	 * Generates a name object.
	 * @since 1.0.0
	 */
	public Name() {}
	
	/**
	 * Generates a name object with the passed parameters.
	 * @param preName The passed prename. 
	 * @param surName The passed surname
	 * @since 1.0.0
	 */
	public Name(String preName, String surName) {
		this.preName = preName;
		this.surName = surName;
	}
	
	/**
	 * Sets the passed prename.
	 * @param preName The passed prename.
	 * @since 1.0.0
	 */
	protected void setPreName(String preName){
		this.preName = preName;
	}
	
	/**
	 * Sets the passed surname.
	 * @param surName The passed surname.
	 * @since 1.0.0
	 */
	protected void setSurName(String surName) {
		this.surName = surName;
	}
	
	/**
	 * Returns the prename.
	 * @return the prename.
	 * @since 1.0.0
	 */
	protected String getPreName() {
		return preName;
	}
	
	/**
	 * Returns the surname.
	 * @return the surname.
	 * @since 1.0.0
	 */
	protected String getSurName() {
		return surName;
	}
	
	/**
	 * Returns the data of the object.
	 * @return the data of the object.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		String outputSring = "";
		if((getPreName() == null) && (getSurName()== null)) {
			outputSring += "There is no name!";
		} else {
			outputSring += "Prename: " + getPreName() + "\n" +
						   "Surname: " + getSurName() + "\n";
		}
		return outputSring;
	}
}