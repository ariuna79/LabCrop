package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

	private static Properties testDataFile;

	static {

		try {

			String filePath = "src/test/resources/testData/Configuration.properties";

			FileInputStream input = new FileInputStream(filePath);

			testDataFile = new Properties();

			testDataFile.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static String getProperty(String keyName) {

		return testDataFile.getProperty(keyName); 
	}

}// end class
