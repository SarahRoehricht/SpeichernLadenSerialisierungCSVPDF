package interfaces;
/**
 * This interface contains the method to save the data in a PDF file.
 * @author Alfred Loran
 * @version 1.0.0
 */
public interface iPDF {
	/**
	 * This method save the data in a PDF file.
	 * @param fileName The passed file name.
	 * @since 1.0.0
	 */
	public void savePDF(String fileName);
}