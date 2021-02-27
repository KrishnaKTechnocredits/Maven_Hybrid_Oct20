package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	private static Properties prop;

	public PropertiesFileReader(String filePath) {
		File file = new File(filePath);
		FileInputStream input;
		try {
			input = new FileInputStream(file);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}

}
