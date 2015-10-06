package classes;
import interfaces.iData;

import java.io.*;
import java.util.Properties;

/**
 * This class contains the method to serialize the program.
 * @author Alfred Loran  am 25.09.2015.
 * @version 1.0.0
 */
public class Serialize implements iData {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;       

	@Override
	public void open(Properties properties) throws IOException {
		String dateiName = properties.getProperty("Filename");

        if (dateiName == null) {
            throw new IOException("Filename not defined!");
        } else {
            if ("s".equals(properties.getProperty("Mode"))) {
                oos = new ObjectOutputStream(new FileOutputStream(dateiName));
            } else if ("l".equals(properties.getProperty("Mode"))){
                ois = new ObjectInputStream(new FileInputStream(dateiName));
            } else {
                throw new IOException("Mode not defined");
            }
        }		
	}

	@Override
	public void write(Object object) throws IOException {
		if (oos == null) {
            throw new IOException("Stream to write not is not open!");
        } else {
            oos.writeObject(object);
        }
	}

	@Override
	public Object read() throws IOException {
		if (ois == null) {
            throw new IOException("Stream to read is not open!");
        }

        try {
            Object object = ois.readObject();
            return object;
        } catch(ClassNotFoundException error) {
            throw new IOException("Could not deserialize!");
        }
	}

	@Override
	public void close(Object object) throws IOException {
		if (ois != null) {
            ois.close();
            ois = null;
        } else if (oos != null) {
            oos.close();
            oos = null;
        }		
	}
}