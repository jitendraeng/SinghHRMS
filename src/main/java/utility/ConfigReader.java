package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private FileInputStream fis;
	private Properties props;

	public Properties init_props() {

		props = new Properties();
		try {
			fis = new FileInputStream("./src/test/resources/properties/Config.properties");
			props.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;

	}

}
