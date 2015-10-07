package interfaces;

public interface iCSV {
	/**
	 * This method saves the data in a CSV file.
	 * @param fileName The passed file name.
	 * @since 1.0.0
	 */
	public void saveCSV(String fileName);
	
	/**
	 * Loads the objects in a CSV file.
	 * @param fileName The passed Filename.
	 * @return the loaded objects.
	 * @since 1.0.0
	 */
	public Object loadCSV(String fileName);
}
