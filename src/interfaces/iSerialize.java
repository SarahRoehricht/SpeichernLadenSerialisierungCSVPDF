package interfaces;

/**
 * This interface contains the methods to save and load serialized data.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iSerialize {
	/**
	 * This method serializes the data of the program.
	 * @param fileName The passed fileName.
	 * @since 1.0.0
	 */
	public void saveSerialize(String fileName);
	
	/**
	 * This method loads the serialized data.
	 * @param fileName The passed file name.
	 * @return the loaded object.
	 * @since 1.0.0
	 */
	public Object loadSerialize(String fileName);
}